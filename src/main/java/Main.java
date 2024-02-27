public class Main {
    public static void main(String[] args) {
        System.out.println(removeConsecutive("aabcccbbad"));
        System.out.println(replaceConsecutive("abcccbad"));
    }

    public static String removeConsecutive(String str) {
        StringBuilder sb = new StringBuilder(str);
        boolean modified = false;
        for (int i = 0; i < sb.length()-1; ) {
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(j) != sb.charAt(i)) {
                    if (j - i >= 3) {
                        sb.delete(i, j);
                        modified = true;
                        break;
                    } else {
                        i = j;
                    }
                }
            }
        }
        if(modified){
            return removeConsecutive(sb.toString());
        }

        return sb.toString();
    }

    public static String replaceConsecutive(String str){
        StringBuilder sb = new StringBuilder(str);
        boolean modified = false;
        for (int i = 0; i < sb.length()-1; ) {
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(j) != sb.charAt(i)) {
                    if (j - i >= 3) {
                        if (sb.charAt(i) - 1 < 'a') {
                            sb.delete(i, j);
                        } else {
                            sb.delete(i + 1, j);
                            sb.replace(i, i + 1, String.valueOf((char) (sb.charAt(i) - 1)));
                            i = i + 1;
                        }
                        modified = true;
                        break;
                    } else {
                        i = j;
                    }
                }
            }
        }
        if(modified){
            return replaceConsecutive(sb.toString());
        }

        return sb.toString();
    }
}


