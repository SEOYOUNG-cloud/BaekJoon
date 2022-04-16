while True:
    pal = list(input())
    if len(pal) == 1:
        if '0' in pal:
            break
        print('yes')
        continue
    comp = []
    for i in range(len(pal)//2):
        comp.append(pal[i])
    for i in range((len(pal) + 1)//2,len(pal)):
        if comp[-1] == pal[i]:
            comp.pop(-1)
    if len(comp) == 0:
        print('yes')
    else:
        print('no')
        
'''
아 일케하면 되네 참나 진짜ㅋㅋㅋ

while True:
    n = input()
    
    if n == '0':
        break
    if n == n[::-1]:  # 뒤집어서 같으면
        print('yes')
    else:
        print('no')
'''