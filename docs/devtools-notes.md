# DevTools Notes - Week 8 Assignment 2

## Network tab observation

Reloading index.html with the Network tab open shows 2 requests:

1. index.html - Status 200, Type: document, Size: 3.2 kB, Time: 8 ms
2. style.css - Status 200, Type: stylesheet, Initiator: index.html:7, Size: 2.2 kB, Time: 24 ms

Both files load successfully with a 200 OK status. style.css is fetched
because index.html references it via the <link> tag on line 7. Total page
load: 2 requests, 5.4 kB transferred, DOMContentLoaded at 52ms.

## Computed CSS property inspected on <nav>

Selected the <nav> element in the Elements panel and checked the Computed tab:

- display: flex
- background-color: rgb(31, 56, 100) (this is #1F3864 in RGB form)
- flex-direction: row

This confirms the CSS rule `nav { display: flex; flex-direction: row;
background-color: #1F3864; }` is being applied and computed correctly by
the browser.