import os
import random

from util.Python.BetterNum import *

def main():
    global limit
    os.mkdir("Data")
    for i in betterRange(1, 3):
        if(i == 1):
            limit = 15
        elif (i == 2):
            limit = 4
        elif (i == 3):
            limit = 2
        os.mkdir("Data/Layer" + str(i))
        os.mkdir("Data/Layer" + str(i) + "/Value")
        os.mkdir("Data/Layer" + str(i) + "/Bias")
        for j in betterRange(0, limit):
            f = open("Data/Layer" + str(i) + "/Value/_" + str(j), "x")
            f.write(str(random.randint(-128, 127)))
            f.close()
            g = open("Data/Layer" + str(i) + "/Bias/_" + str(j), "x")
            g.write(str(random.randint(-128, 127)))
            g.close()

if __name__ == "__main__":
    main()