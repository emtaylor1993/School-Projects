//
// timeout queue
//

#include "os.h"
#include "llist.h"

struct event {
	LL_PTRS;
	int timeout;
	int repeat_interval;
	pfv_t go;
	unsigned int data;
};

// for use with the int handle_timeoutq_event(void); function
#define UNHANDLED 	0
#define HANDLED		1

#define MAX_EVENTS	8
struct event queue[ MAX_EVENTS ];

// list anchors -- important, but ignore them; they are never used directly
llobject_t TQ;
llobject_t FL;

struct event *timeoutq;
struct event *freelist;

unsigned int then_usec;

// definitions of functions used in Project 0
extern unsigned int timediff(unsigned int now, unsigned int then);
extern unsigned int gettime(void);

//
// sets up concept of local time
// initializes the timeoutq and freelist
// fills the freelist with entries
// timeoutq is empty
//
void init_timeoutq(void) {
	int i;

	then_usec = gettime();

	timeoutq = (struct event *)&TQ;
	LL_INIT(timeoutq);
	freelist = (struct event *)&FL;
	LL_INIT(freelist);

	for (i=0; i<MAX_EVENTS; i++) {
		struct event *ep = &queue[i];
		LL_PUSH(freelist, ep);
	}

	return;
}

//
// account for however much time has elapsed since last update
// return timeout or MAX
//
int bring_timeoutq_current(void) {
	unsigned int now_usec = gettime();
	unsigned int difference = timediff(now_usec, then_usec);
	struct event *ep = LL_HEAD(timeoutq);
	int time_to_wait;
	
	if (!ep) {
		time_to_wait = 0 - difference;
	} else {
		time_to_wait = ep->timeout - difference;
	}
	
	if (time_to_wait >= MAX_SLEEP_INTERVAL) {
		return MAX_SLEEP_INTERVAL;
	} else {
		return time_to_wait;
	}
}

//
// get a new event structure from the freelist,
// initialize it, and insert it into the timeoutq
// 
void create_timeoutq_event(int timeout, int repeat, pfv_t function, unsigned int data) {
	struct event *ep = LL_POP(freelist);
	struct event *tp;
	
	ep->timeout = timeout;
	ep->repeat_interval = repeat;
	ep->go = function;
	ep->data = data;
	
	if (LL_IS_EMPTY(timeoutq)) {
		LL_PUSH(timeoutq, ep);
	} else {
		LL_EACH(timeoutq, tp, struct event) {
			if (ep->timeout > tp->timeout) {
				ep->timeout -= tp->timeout;
			} else {
				tp->timeout -= ep->timeout;
				LL_L_INSERT(tp, ep);
				break;
			}
		}
	}
}

//
// bring the time current
// check the list to see if anything expired
// if so, do it - and either return it to the freelist 
// or put it back into the timeoutq
//
// return whether or not you handled anything
//
int handle_timeoutq_event(void) {
	if (LL_HEAD(timeoutq) != NULL) {
		struct event *ep = LL_HEAD(timeoutq);
		struct event *tp;
		
		if (ep->timeout < 1) {
			pfv_t tmp = ep->go;
			(*tmp)(ep->data);
			LL_POP(ep);
			
			if (ep->repeat_interval == 0) {
				LL_PUSH(freelist, ep);
				return HANDLED;
			} else {
				ep->timeout = ep->repeat_value;
				LL_EACH(timeoutq, tp, struct event) {
					if (ep->timeout > tp->timeout){
						ep->timeout -= tp->timeout;
					} else {
						tp->timeout -= ep->timeout;
						LL_L_INSERT(tp, ep);
						break;
					}
				}
				return HANDLED;
			}
		} 
	} else {
		return UNHANDLED;
	}
	
	return UNHANDLED;
}
