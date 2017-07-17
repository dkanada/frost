### Recommended: 
- **use 48x48 pixel** icons. Other sizes are ok, but we will have to scale up or down (more work for us)
- **use the templates** from /templates , if your icon will have a **square / circle / rectangular shape**. 
- **upload** the SVG files into the **/other directory**
- At one point in the future, we would like to use **vector (SVG, AVDX) instead of raster (PNG) graphics** inside the app, 
because vector graphics are more efficient and customizable than raster graphics.  
Android does not support SVG (scalable vector graphics) directly, it only supports so-called **AVD XML (Android vector drawable XML).** 
SVG can easily be converted to AVD XML, but AVD XML **does not support some SVG features**.  
Before contributing your SVG icon, **open it inside a text editor and scan it for the following SVG features**: 
    - **``matrix`` or ``transform``** attributes. 
    - **``fill-rule:evenodd``** attributes. 
    - **the scientific E-notation ```[0-9]{1,3}\.[0-9]{1,3}e-[0-9]``` (in regular expression) for really small numbers**. 

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
- **scientific e-notation**. Just replace them with the normal notation. E.g. ``5e-6 = 5 * 10^(-6) = 0.000005`` or ``4.73e-3 = 4,73 * 10^(-3) = 0.00473``. The number after the "**e**" tells you **how many zeroes should come at the beginning**. **If the number is lower than 0.001** (so the number after the "e-" is higher than 3), it shouldn't make a difference to the look of the picture, if you just **replace the complete number with zero (0)**. 