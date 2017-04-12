import sys
from com.android.monkeyrunner import MonkeyRunner as mr
from com.android.monkeyrunner import MonkeyDevice as md
from com.android.monkeyrunner import MonkeyImage as mi

device = mr.waitForConnection(1.0,'emulator-5554')
device2 = mr.waitForConnection(1.0,'emulator-5556')
if not device:
    print >> sys.stderr,"fail"
    sys.exit(1)
componentName='kg.monkey/.MonkeyActivity'
device.startActivity(component=componentName)
mr.sleep(3.0)
device.type('asd')
device.press('KEYCODE_ENTER')
mr.sleep(3.0)
result = device.takeSnapshot()
result2 = device2.takeSnapshot()
result.writeToFile('takeSnapshot\\result1.png','png');
result2.writeToFile('takeSnapshot\\result2.png','png');
