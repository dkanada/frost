### Recommended: 
- **use 48x48 pixel** icons. Other sizes are ok, but we will have to scale up or down (more work for us)
- **use the templates** from /templates , if your icon will have a **square / circle / rectangular shape**. 
- **upload** the SVG files into the **/other directory**
- At one point in the future, we would like to use **vector (SVG, AVDX) instead of raster (PNG) graphics** inside the app, 
because vector graphics are more efficient and customizable than raster graphics.  
Android does not support SVG (scalable vector graphics) directly, it only supports so-called **AVD XML (Android vector drawable XML).** 
SVG can easily be converted to AVD XML, but AVD XML **does not support some SVG features**. P 
Before contributing your SVG icon, **open it inside a text editor (it's just basic text file!) and scan it for the following SVG features**: 
    - **``matrix`` or ``transform``** attributes: 

    Example: 
```<?xml version="1.0" encoding="UTF-8"?>
<svg version="1.1" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg"><rect transform="rotate(-45)" x="24" y="24" width="12" height="12" ry="5" fill="#fff"/>```

    - **``fill-rule:evenodd``** attributes: 

    Example: 
```<?xml version="1.0" encoding="UTF-8"?> 
<svg version="1.1" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg"> 
<path d="M 35,46 46,35 24,13 35,2 46,13 13,46 2,35 24,13 13,2 2,13 Z" fill="#fff" fill-rule="evenodd"/> 
</svg>```

    - **the scientific E-notation ``[0-9]{1,3}\.[0-9]{1,3}e-[0-9]`` (in regular expression) for really small numbers**: 

    Example:
```<?xml version="1.0" encoding="UTF-8"?>
<svg version="1.1" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg">
<path d="m24.051 4l0.041016 0.041016v-0.039062h13.912c-0.001574-3.6e-6 -0.002331-0.0019531-0.003906-0.0019531h-13.949z" fill="#fff"/>
<path d="m6 8c-1.108 0-2 0.892-2 2v28c0 1.108 0.892 2 2 2h36c1.108 0 2-0.892 2-2v-28c0-1.108-0.892-2-2-2h-36zm30.945 6.7109a3.6539 3.6539 0 0 1 3.6523 3.6543 3.6539 3.6539 0 0 1 -3.6523 3.6543 3.6539 3.6539 0 0 1 -1.2598 -0.23047l-3.1758 4.6211a3.0918 3.0918 0 0 1 0.67773 1.9297 3.0918 3.0918 0 0 1 -3.0918 3.0918 3.0918 3.0918 0 0 1 -3.0918 -3.0918 3.0918 3.0918 0 0 1 0.019532 -0.3457l-6.8047-2.9395a3.0918 3.0918 0 0 1 -2.3594 1.0938 3.0918 3.0918 0 0 1 -1.8145 -0.59375l-4.1055 3.0996a2.3048 2.3048 0 0 1 0.072266 0.56055 2.3048 2.3048 0 0 1 -2.3047 2.3047 2.3048 2.3048 0 0 1 -2.3047 -2.3047 2.3048 2.3048 0 0 1 2.3047 -2.3047 2.3048 2.3048 0 0 1 1.1484 0.31055l4.1035-3.0996a3.0918 3.0918 0 0 1 -0.18945 -1.0645 3.0918 3.0918 0 0 1 3.0898 -3.0918 3.0918 3.0918 0 0 1 3.0918 3.0918 3.0918 3.0918 0 0 1 -0.019531 0.34766l6.8027 2.9395a3.0918 3.0918 0 0 1 2.3613 -1.0957 3.0918 3.0918 0 0 1 0.93164 0.14648l3.1738-4.623a3.6539 3.6539 0 0 1 -0.91016 -2.4062 3.6539 3.6539 0 0 1 3.6543 -3.6543z" fill="#fff"/></svg>```

If your SVG icon contains **any of these SVG features**, please **first replace them**! 

### How to replace ...
- **matrix / transform elements in Inkscape**. For some of the following possibilities, you might need to remove the matrix/transform attribute before, and apply the matrix/transform changes differently. To remove them, go to Edit -> XML Editor (CTRL+SHIFT+X) and **delete all matrix / transform attributes**. 
    - **Possibility 1:** combine one of the matrix / transform objects with another one (select them, then CTRL+PLUS ). 
        - advantage: always works. 
        - disadvantage:  You loose some special editing functionality (e.g. no more rounded corners for rect's) and your file gets bigger. 
    - **Possibility 2:** 
        - problem: if multiple objects are combined into a group, and you only select this group when moving objects, the group will get a transform attribute. 
        - solution: 1. Un-group the objects (SHIFT+G), 2. Move the objects one-by-one OR select multiple ones by keeping SHIFT pressed during selection and move them simultaneously. 3. Group them again. 
    - **Possibility 3:**
        - When moving objects in Inkscape the next time, do **not** do it with your keyboard / manually, but **use the transform window in Inkscape**
            1. Select all objects you would like to move (e.g. CTRL+A)
            2. Go to Object -> Transform (CTRL+SHIFT+M)
            3. Uncheck "Relative Move" and check "Apply to each object separately". 
            4. Specify the horizontal and vertical values for movement. 
            5. Click Apply. 
- **fill-rule:evenodd** attributes. As far as I know, they can just be omitted (deleted). 
- **scientific e-notation**. Just replace them with the normal notation. E.g. ``5e-6 = 5 * 10^(-6) = **0.000005**`` or ``4.73e-3 = 4,73 * 10^(-3) = **0.00473**``. The number after the "**e**" tells you **how many zeroes should come at the beginning**. **If the number is lower than 0.001** (so the number after the "e-" is higher than 3), it shouldn't make a difference to the look of the picture, if you just **replace the complete number with zero (0)**. 