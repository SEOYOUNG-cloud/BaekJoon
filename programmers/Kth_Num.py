# K번째 수

def solution(array, commands):
    answer = []
    for now in range(len(commands)):
        i = int(commands[now][0])
        j = int(commands[now][1])
        k = int(commands[now][2])
        
        temp_arr = sorted(array[i-1:j])
        answer.append(temp_arr[k-1])
   
        
    return answer

# 다른 사람 풀이
# list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))

# for command in commands:
#   i,j,k = command