import sys
from com.android.monkeyrunner import MonkeyRunner as mr
from com.android.monkeyrunner import MonkeyDevice as md
from com.android.monkeyrunner import MonkeyImage as mi

device = mr.waitForConnection()
if not device:
    print >> sys.stderr,"fail"
    sys.exit(1)
componentName='com.android.calculator2/com.android.calculator2.Calculator'
device.startActivity(component=componentName)
mr.sleep(3.0)
device.type('asd')
device.press('KEYCODE_ENTER')
mr.sleep(3.0)
result = device.takeSnapshot()

result.writeToFile('resul1t\\result1.png','png')
