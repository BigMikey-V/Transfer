package github.mikey;

import static java.lang.Math.pow;

public class Transfer {

    private String result = "", atmp = "", btmp = "";

    public void init(){
        result = "";
        atmp = "";
        btmp = "";
    }

    public String toBinary(String x){
        double b = Double.parseDouble(x);
        long a = (int) b;

        this.init();
        b -= a;
        if(b > 0 | a >= 0){
            while(b > 0){
                b *= 2;
                btmp += ((int) b);
                if(b >= 1) b -= (int) b;
            }
            while(a > 0){
                atmp += a % 2;
                a /= 2;
            }
        }
        atmp += "b0";
        result = new StringBuffer(atmp).reverse().toString();
        if(btmp.length() > 1) result += "." + btmp;

        return result;
    }

    public String toOct(String x){
        double b = Double.parseDouble(x);
        long a = (int) b;

        this.init();
        b -= a;
        if(b > 0 | a >= 0){
            while(b > 0){
                b *= 8;
                btmp += ((int) b);
                if(b >= 1) b -= (int) b;
            }
            while(a > 0){
                atmp += a % 8;
                a /= 8;
            }
        }
        atmp += "0";
        result = new StringBuffer(atmp).reverse().toString();
        if(btmp.length() > 1) result += "." + btmp;

        return result;
    }

    public String toHex(String x){
        double b = Double.parseDouble(x);
        long a = (int) b;

        this.init();
        b -= a;
        if(b > 0 | a >= 0){
            while(b > 0){
                b *= 16;
                switch ((int) b) {
                    default -> btmp += ((int) b);
                    case 10 -> btmp += ("A");
                    case 11 -> btmp += ("B");
                    case 12 -> btmp += ("C");
                    case 13 -> btmp += ("D");
                    case 14 -> btmp += ("E");
                    case 15 -> btmp += ("F");
                }
                if(b >= 1) b -= (int) b;
            }
            while(a > 0){
                atmp += a % 16;
                a /= 16;
            }
        }
        atmp += "x0";
        result = new StringBuffer(atmp).reverse().toString();
        if(btmp.length() > 1) result += "." + btmp;

        return result;
    }

    public String toOrigin(int flag, String x){
        double sum = 0;
        String tmp = "";

        if(flag == 2 || flag == 8){
            double b = Double.parseDouble(x);
            int a = (int) b;

            this.init();
            b -= a;
            tmp = a + "";
            for(int i = tmp.length() - 1, j = 0; i >= 0; i--, j++)
                sum += Integer.parseInt(tmp.charAt(i) + "") * pow(flag, j);
            tmp = b + "";
            if(b > 0) for(int i = 0, j = -1; i <= tmp.length(); i++, j--)
                sum += 1.0 * Integer.parseInt(tmp.charAt(i) + "") * pow(flag, j);
        }
        else if(flag == 16){
            String a = "", b = "";
            int i = 0, status = 0;

            for(i = 0; i < x.length() && x.charAt(i) != '.'; i++) a += x.charAt(i);
            if(i < x.length() - 1 && x.charAt(i) == '.') for(i++; i < x.length(); i++) b += x.charAt(i);
            for(i = 0; i < a.length(); i++)
                if(a.charAt(i) == 'A' || a.charAt(i) == 'B' || a.charAt(i) == 'C' ||
                        a.charAt(i) == 'D' || a.charAt(i) == 'E' || a.charAt(i) == 'F') status = 1;
            if(status == 1) for(int j = a.length() - 1, k = 0; j >= 0; j--, k++)
                 switch(a.charAt(j)){
                    default -> sum += Integer.parseInt(a.charAt(j) + "") * pow(flag, k);
                    case 'A' -> sum += 10 * pow(flag, k);
                    case 'B' -> sum += 11 * pow(flag, k);
                    case 'C' -> sum += 12 * pow(flag, k);
                    case 'D' -> sum += 13 * pow(flag, k);
                    case 'E' -> sum += 14 * pow(flag, k);
                    case 'F' -> sum += 15 * pow(flag, k);
                }
            else sum += Integer.parseInt(a);
            for(i = 0; i < x.length(); i++) if(x.charAt(i) == '.') status = -1;
            if(status == -1){
                for(int j = 0, k = -1; j < b.length(); j++, k--)
                    switch(b.charAt(j)){
                        default -> sum += Integer.parseInt(b.charAt(j) + "") * pow(flag, k);
                        case 'A' -> sum += 10 * pow(flag, k);
                        case 'B' -> sum += 11 * pow(flag, k);
                        case 'C' -> sum += 12 * pow(flag, k);
                        case 'D' -> sum += 13 * pow(flag, k);
                        case 'E' -> sum += 14 * pow(flag, k);
                        case 'F' -> sum += 15 * pow(flag, k);
                    }
            }
        }
        result = sum + "";

        return result;
    }
}
