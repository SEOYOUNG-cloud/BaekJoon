def solution(new_id):
    # 1단계
    new_id = new_id.lower()
    
    # 2단계
    for i in new_id:
        if i.isalnum() or i == '-' or i == '_' or i == '.':
            continue
        else:
            new_id = new_id.replace(i, '')
    
    # 3단계 여기 참고했음
    while '..' in new_id:
        new_id = new_id.replace('..', '.')
    
    # 4단계
    if new_id.startswith('.'):
        new_id = new_id[1:]
    if new_id.endswith('.'):
        new_id = new_id[:len(new_id) - 1]
        
    # 5단계
    if new_id == '':
        new_id = 'a'
        
    # 6단계
    if len(new_id) >= 16:
        new_id = new_id[:15]
    if new_id.endswith('.'):
        new_id = new_id[:14]
    
    # 7단계
    if len(new_id) == 2:
        new_id = new_id + new_id[1]
    elif len(new_id) == 1:
        new_id = new_id + new_id[0] + new_id[0]
    
    return new_id