import os
import random
from util.Python.BetterNum import *

def main():
    #General
    global limit
    os.mkdir("Data")
    for i in betterRange(1, 3):
        limit = getLimit(i)
        #Neurons
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
        #NeuroLinks
        if (i != 3):
            os.mkdir("Data/Layer" + str(i) + "/Links")
            for j in betterRange(0, limit):
                os.mkdir("Data/Layer" + str(i) + "/Links/_" + str(j))
                for k in betterRange(0, getLimit(i+1)):
                    f = open("Data/Layer" + str(i) + "/Links/_" + str(j) + "/_" + str(k), "x")
                    f.write(str(random.randint(-128, 127)))
                    f.close()

def getLimit(n):
    if (n == 1):
        return 15
    elif (n == 2):
        return 4
    elif (n == 3):
        return 2

if __name__ == "__main__":
    main()