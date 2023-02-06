import utime
from machine import Pin, I2C
from ssd1306 import SSD1306_I2C
from pico_ir import readcode
i2c=I2C(0,sda=Pin(0),scl=Pin(1))
oled = SSD1306_I2C(128,64,i2c)
oled.text("Whatever")
oled.show()

pin_in = Pin(20,Pin.IN,Pin.PULL_UP)

while True:
    out = read_code(pin_in)
    if out:
        try:
            validate_code(out)
            print(out)
            utime.sleep(3)
        except InvalidCodeException:
            print("InvalidCodeException" + out)