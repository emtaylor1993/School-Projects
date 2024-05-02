%% Emmanuel Taylor
% ENEE222 - Elements of Discrete Signal Analysis

% Lab Assignment 10
[x, Fs] = wavread('dialtones10.wav');
N = length(x); 
% The length of the vector is 77328 and Fs = 8192.
n = 0:N-1;
t = n/Fs;
plot(t, x)
grid
axis tight
xlabel 'Time'
ylabel 'Value'
title 'Plot of vector x in the Time Domain'

keystring = '2*6#2015';
T = 0.27;
Tpause = 0.93;

% Finding the first dialtone. -- 2
x1 = x(round(0.465*Fs):round(0.735*Fs));
N1 = length(x1);
k1 = 0:N1-1;
F1 = (k1/N1)*Fs;
X1 = fft(x1);
figure;
plot(F1, abs(X1))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of First Dialtone'

% Finding the second dialtone. -- *
x2 = x(round(1.665*Fs):round(1.935*Fs));
N2 = length(x2);
k2 = 0:N2-1;
F2 = (k2/N2)*Fs;
X2 = fft(x2);
figure;
plot(F2, abs(X2))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of Second Dialtone'

% Finding the third dialtone. -- 6
x3 = x(round(2.865*Fs):round(3.135*Fs));
N3 = length(x3);
k3 = 0:N3-1;
F3 = (k3/N3)*Fs;
X3 = fft(x3);
figure;
plot(F3, abs(X3))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of Third Dialtone'

% Finding the fourth dialtone. -- #
x4 = x(round(4.065*Fs):round(4.335*Fs));
N4 = length(x4);
k4 = 0:N4-1;
F4 = (k4/N4)*Fs;
X4 = fft(x4);
figure;
plot(F4, abs(X4))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of Fourth Dialtone'

% Finding the fifth dialtone. -- 2
x5 = x(round(5.265*Fs):round(5.535*Fs));
N5 = length(x5);
k5 = 0:N5-1;
F5 = (k5/N5)*Fs;
X5 = fft(x5);
figure;
plot(F5, abs(X5))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of Fifth Dialtone'

% Finding the sixth dialtone. -- 0
x6 = x(round(6.465*Fs):round(6.735*Fs));
N6 = length(x6);
k6 = 0:N6-1;
F6 = (k6/N6)*Fs;
X6 = fft(x6);
figure;
plot(F6, abs(X6))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of Sixth Dialtone'

% Finding the seventh dialtone. -- 1
x7 = x(round(7.665*Fs):round(7.935*Fs));
N7 = length(x7);
k7 = 0:N7-1;
F7 = (k7/N7)*Fs;
X7 = fft(x7);
figure;
plot(F7, abs(X7))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of Seventh Dialtone'

% Finding the eighth dialtone. -- 5
x8 = x(round(8.865*Fs):round(9.135*Fs));
N8 = length(x8);
k8 = 0:N8-1;
F8 = (k8/N8)*Fs;
X8 = fft(x8);
figure;
plot(F8, abs(X8))
grid
axis tight
xlabel 'Frequency'
ylabel 'Value'
title 'Magnitude Spectrum of Eighth Dialtone'

x_est = dtmfdial(keystring, Fs, T, Tpause);