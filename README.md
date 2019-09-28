<img src='https://raw.githubusercontent.com/dkanada/frost/master/metadata/en-US/header-background.png'>

An icon pack forked from [ICEcons](https://github.com/1C3/ICEcons) with the goal of providing icons mostly for F-Droid and other FOSS apps. It was designed to look clean and simple, featuring only white icons and transparency for a see-through effect.

[<img src="https://f-droid.org/badge/get-it-on.png" alt="Get it on F-Droid" height="90">](https://f-droid.org/packages/com.dkanada.icecons)

Frost includes support for Trebuchet, KISS, Nova, Apex, Holo, ZenUI, ADW, and many more launchers.
There are over **400 icons**, as well as a few **4K wallpapers** included. Submitting icon requests helps a lot, but maintaining the project (as you may imagine) takes a lot of time and effort, so please be patient about adding new icons. Contributions for new icons are always welcome, and no experience with programming is necessary.

<img src='https://raw.githubusercontent.com/dkanada/frost/master/metadata/en-US/screenshots.png'>

## Icon Requests

This app doesn't have an icon request feature, so you'll have to do the following steps.

1. **Install [Turtl](https://f-droid.org/packages/org.xphnx.iconsubmit)** which can extract the icons and class names of your apps.
2. **Open Turtl** and follow the process to save the new zip file to your phone.
3. **[Make an issue](https://github.com/dkanada/frost/issues/new)** titled "Icon Request" and attach the zip file.

If Turtl is not working on your device, you can also use [Applications Info](https://f-droid.org/packages/com.majeur.applicationsinfo) or any equivalent app to collect the **package name** of the app ($PACKAGE_NAME) and the **main activity name** of the app ($ACTIVITY_NAME) launchable in Applications Info with no errors. Work is being done to simplify this process.

## Contributing

Help with any aspect of the app is much appreciated! **You don't have to know how to code!** If you know how to work with vectors in a program that supports the SVG format. [Inkscape](https://inkscape.org/en/) is recommended but not necessary. Please read the [guide on contributing](CONTRIBUTING.md) before making big changes! It also includes some personal preferences on how to work with Inkscape. If you don't use Inkscape you can just ignore them.

**Note:** I want to accept as many contributions as possible, but will only merge icons that have been manually created using shapes and paths in a vector editing program. I don't think the quality is high enough from tools that automatically generate vector images.

Quick Guide:
1. Fork the repository to your GitHub account
2. Download the templates provided [here](templates) and design the new icons
3. Upload the SVG icons to your repository's **/other** folder
4. Create a pull request and explain your changes
5. Provide the activity names of the new apps
   - These should look something like `com.dkanada.icecons/com.dkanada.icecons.MainActivity`
   - If you want to help even more you can add your new icons to the appfilter.xml file

## Illustration

<img src='https://raw.githubusercontent.com/dkanada/frost/master/metadata/en-US/complete-background.png'/>
