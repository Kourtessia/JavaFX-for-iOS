JavaFX-for-iOS
==============

JavaFX (OpenJFX) AddressBook app for iOS using RoboVM

<div class="highlight highlight-bash"><pre>
mvn install:install-file -Dfile=/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/jfxrt.jar -DgroupId=com.oracle.javafx \
    -DartifactId=javafx -Dversion=2.2 -Dpackaging=jar
</pre></div>
	
Then maven will install jfxrt.jar then you can simply reference it as 
 
 &lt;<span class="hl-tag">dependency</span>&gt;<br>
 &lt;<span class="hl-tag">groupId</span>&gt;com.oracle.javafx&lt;<span class="hl-tag">/groupId</span>&gt;<br>
 &lt;<span class="hl-tag">artifactId</span>&gt;javafx&lt;
 <span class="hl-tag">/artifactId</span>&gt;<br>
 &lt;<span class="hl-tag">version</span>&gt;2.2&lt;<span class="hl-tag">/version</span>&gt;<br>
 &lt;<span class="hl-tag">/dependency</span>&gt;

	
To let RoboVM make an iOS app on iphone, ipad simulator or iOS Device we need to call from the command line:	

<code>mvn robovm:iphone-sim</code>
<br><code>mvn robovm:ipad-sim</code>
<br><code>mvn robovm:ios-device</code>



!![ScreenShot](https://github.com/Kourtessia/robovm-sample-jfx-app/blob/master/images/EnterName.png?raw=true)'
!![ScreenShot](https://github.com/Kourtessia/robovm-sample-jfx-app/blob/master/images/HelloWorld.png?raw=true)'

