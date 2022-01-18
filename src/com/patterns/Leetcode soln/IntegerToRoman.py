class Solution(object):
    def intToRoman(self, num):

        Mmod = num % 1000
        Mrem = num // 1000

        if Mmod >= 900:
            M = "M" * Mrem + "CM"
            Mmod -= 900
        else:
            M = "M" * Mrem

        Dmod = Mmod % 500
        Drem = Mmod // 500

        if Dmod >= 400:
            D = "D" * Drem + "CD"
            Dmod -= 400
        else:
            D = "D" * Drem

        Cmod = Dmod % 100
        Crem = Dmod // 100
        if Cmod >= 90:
            C = "C" * Crem + "XC"
            Cmod -= 90
        else:
            C = "C" * Crem

        Lmod = Cmod % 50
        Lrem = Cmod // 50

        if Lmod >= 40:
            L = "L" * Lrem + "XL"
            Lmod -= 40
        else:
            L = "L" * Lrem

        Xmod = Lmod % 10
        Xrem = Lmod // 10

        if Xmod >= 9:
            X = "X" * Xrem + "IX"
            Xmod -= 9
        else:
            X = "X" * Xrem

        Vmod = Xmod % 5
        Vrem = Xmod // 5
        V = "V" * Vrem

        if Vmod == 4:
            I = "IV"
        else:
            I = "I" * Vmod

        Roman = M + D + C + L + X + V + I
        return (Roman)


