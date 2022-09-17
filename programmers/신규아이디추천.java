class Solution {
    public String solution(String new_id) {        
        // 1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        
        // 2. 알파벳 소문자, 숫자, (-), (_), (.) 제외하고 제거
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<new_id.length(); i++){
            if((new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z')
              || (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9')
              || new_id.charAt(i) == '-'
              || new_id.charAt(i) == '_'
              || new_id.charAt(i) == '.'){
                sb.append(new_id.charAt(i));
            }
        }
        
        new_id = sb.toString();
        
        // 3. (.)가 두 번 이상 연속된 부분을 하나로 바꾸기
        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        
        
        // 4. (.)가 처음이나 끝이면 제거
        if(new_id.length() > 0){
            if(new_id.charAt(0) == '.')
                new_id = new_id.substring(1);
        }
    if(new_id.length() > 0){
        if(new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0, new_id.length()-1);
    }
        
        // 5. 빈 문자열이면 "a" 넣음
        if(new_id.length() == 0)
            new_id = "a";
        
        // 6. 16자 이상이면 15개 남김, 마지막이 (.)이 되면 없앰
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
        }
        if(new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0, new_id.length()-1);
        
        // 7. 길이가 2자 이하면 마지막 문자를 3개만큼 늘림
        while(new_id.length() <= 2){
            new_id = new_id + String.valueOf(new_id.charAt(new_id.length()-1));
        }
    
        return new_id;
    }
    
}