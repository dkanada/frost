# ICEcons

An icon pack forked from [ICEcons by 1C3](https://github.com/1C3/ICEcons) with a goal of providing icons mostly for **F-Droid** and other **FOSS** apps. Designed to look *clean and simple*, featuring only white color and transparency for a satisfying see-through effect. (See illustration below)

Support for Trebuchet (CM/LOS), KISS, Nova, Apex, Holo, ZenUI (ASUS), ADW and many more launchers although not applicable via the app itself.

There are about **270 icons** as well as a few **4K wallpapers** included. Submitting **icon requests** helps a lot, but maintaining the project as you may imagine takes a lot of time and effort so please be patient about adding new icons or contribute some yourself.

## Download

[<img src="https://f-droid.org/badge/get-it-on.png" alt="Get it 
on F-Droid" 
height="90">](https://f-droid.org/app/com.dkanada.icecons/)

## Icon Requests

The app doesn't have an icon request feature so you'll have to do the following steps:

1. **Install [Turtl](https://f-droid.org/app/org.xphnx.iconsubmit)**, an app which extracts icon images and xml data from apps and packs these in a convenient .zip file.
2. **Open Turtl**, select the missing icons and tap "Send Request". Don't select any option, **close Turtl**.
3. **Obtain the .zip file** located in your device's internal storage in a folder named ".icon_request". _It's **hidden** so make sure to enable viewing hidden files in your file manager_.
4. **[Make an issue](https://github.com/dkanada/ICEcons/issues/new)** titled "Icon Request" and attach the .zip file.

If Turtl is not working on your device, you can also use [Applications 
Info](https://f-droid.org/app/com.majeur.applicationsinfo) to collect 
- the **package name** of the app ( $PACKAGE_NAME )
- the **main activity name** of the app ( $ACTIVITY_NAME ), launchable in Applicationsinfo + no error)
Unfortunately, you can't collect the icon via Applicationsinfo - you will need to 

```
cd ~
mkdir $PACKAGE_NAME; 
mkdir collection
#from computer via ADB 
adb pull /data/app/${PACKAGE_NAME}-1/base.apk $PACKAGE_NAME/; 
#from terminal app on android: 
cp /data/app/${PACKAGE_NAME}-1/base.apk $PACKAGE_NAME/
cd $PACKAGE_NAME; unzip base.apk; cd res/drawable-xxhdpi*; 
mv ic_launcher.png ~/collection/${PACKAGE_NAME}__${ACTIVITY_NAME}.png
cd ~
``` 
All png icon request icons should now be located at ~/collection/*. 
Zip this folder and follow steps 3 + 4 just like with Turtl. 

Work is being done to simplify this process.

## Contributing

### **Help with any aspect of the app is much appreciated!**

We would eventually like to port [moonshine](https://github.com/natewren/moonshine-iconpack) if we ever have the time using the code from this app.

**You don't have to know how to code** if you know how to work with vectors in a program that supports the SVG format.
[Inkscape](https://inkscape.org/en/) is recommended, but not necessary.

Please read the [guide on contributing](CONTRIBUTING.md) before! It also includes some (personal) tips on how to work with Inkscape. If you don't use Inkscape, please ignore these tips. 

Quick guide for adding your icons:
1. Fork the repository to your GitHub account.
2. Download the templates provided [here](templates) and make the icons as close to these as possible.
3. Upload the SVG icons to your repository's **/other** folder.
4. Create a pull request and explain your changes (*e.g. Add new SVGs*).
5. Provide the AppActivity names of the apps that you've added icons for (obtained by Turtl or any other means). These should look something like this: `com.dkanada.icecons/com.dkanada.icecons.MainActivity` **OR** if you want to help even more edit the appfilter.xml file located in app/src/main/res/xml/ by adding the AppActivity and the rest of the information needed there.

## Illustration

<img src='https://raw.githubusercontent.com/dkanada/ICEcons/master/icons.jpg'/>
