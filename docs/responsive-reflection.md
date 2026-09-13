# Responsive Reflection

The calculator's browser version (HTML/CSS) presents all its controls
visually at once - a grid of buttons and a display - and a user could
interact with them in any order at their own pace, whereas the Java CLI
version uses Scanner to block and wait for one input at a time, strictly
in sequence (first number, then operator, then second number). The browser
version also adapts its layout responsively across screen sizes using
media queries, something the terminal-based CLI has no equivalent of,
since a terminal is just a fixed-width text stream. What is missing from
the browser version compared to the Java CLI is any actual computation -
the HTML/CSS calculator has no JavaScript wired in, so clicking its
buttons does not calculate anything or update the display; all of the
arithmetic logic, error handling, and exception-based validation that the
Java version has (division by zero handling, input validation, etc.)
simply does not exist yet in the browser version.