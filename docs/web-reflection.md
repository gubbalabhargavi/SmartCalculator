# Web UI Reflection

## Network tab observation

Opening index.html in Chrome and checking DevTools' Network tab shows exactly
two requests: index.html itself (the document) and style.css (loaded as a
stylesheet, initiated by index.html). Both return status 200 and load in a
few milliseconds. There are no other requests - no fonts, no images, no
external scripts, no server calls - confirming this is a fully static page
with zero backend dependency.

## CLI vs Web UI input comparison

The CLI calculator collects input through a Scanner reading one value at a
time from the terminal - the program pauses execution and blocks, waiting
for the user to type a number, press Enter, then repeats for the operator
and second number, all in a strict sequential order. The web UI instead
presents all seventeen buttons visually at once, and a user could in
principle click them in any order, at any pace, with immediate visual
feedback on the display - there's no blocking wait for the whole program
the way Scanner.nextLine() blocks a CLI thread. The CLI's structure is
inherently turn-based and linear; the web UI's structure is inherently
event-driven, even though right now it has no event handling wired in
yet.

## Where JavaScript would be needed

JavaScript would be needed to attach click event listeners to each button
so that clicking a number or operator actually updates the #screen input
and clicking equals actually computes and displays a result - right now
the buttons are purely visual and produce no behavior at all.