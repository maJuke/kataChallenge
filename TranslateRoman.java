package kataChallenge;

class TranslateRoman {
    public static int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char chAfter;
            char chBefore;
            if (i != (s.length() - 1))
                chAfter = s.charAt(i+1);
            else
                chAfter = ' ';
            if (i != 0)
                chBefore = s.charAt(i-1);
            else
                chBefore = ' ';
            switch (ch) {
                case ('I') -> {
                    if (chAfter == 'V')
                        res += 4;
                    else if (chAfter == 'X')
                        res += 9;
                    else
                        res++;
                }
                case ('V') -> {
                    if (chBefore == 'I') {
                    } else
                        res += 5;
                }
                case ('X') -> {
                    if (chBefore == 'I') {
                    } else if (chAfter == 'L')
                        res += 40;
                    else if (chAfter == 'C')
                        res += 90;
                    else
                        res += 10;
                }
                case ('L') -> {
                    if (chBefore == 'X') {
                    } else
                        res += 50;
                }
                case ('C') -> {
                    if (chBefore == 'X') {
                    } else if (chAfter == 'D')
                        res += 400;
                    else if (chAfter == 'M')
                        res += 900;
                    else
                        res += 100;
                }
                case ('D') -> {
                    if (chBefore == 'C') {
                    } else
                        res += 500;
                }
                case ('M') -> {
                    if (chBefore == 'C') {
                    } else
                        res += 1000;
                }
            }
        }
        return res;
    }
    public static String intToRoman(int s) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(s >= values[i])
            {
                s = s - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }
}
