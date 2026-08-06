class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char substitute='a';

        for(int i=0; i< key.length();i++){
            char ch = key.charAt(i);
            if(ch != ' ' && !map.containsKey(ch)){
                map.put(ch,substitute);
                substitute++;
            }
        }

        StringBuilder decoded = new StringBuilder();

        for(int i=0; i< message.length();i++){
            char ch = message.charAt(i);
            if(ch ==' '){
                decoded.append(' ');
            } else {
                decoded.append(map.get(ch));
            }
        }
        return decoded.toString();
    }
}