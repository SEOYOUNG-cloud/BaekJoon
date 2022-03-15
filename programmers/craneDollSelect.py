def solution(board, moves):
    answer = 0
                
    my_doll = []
    for out in moves:
        for i in range(len(board)):
            if board[i][out - 1] != 0:
                if len(my_doll) == 0:
                     my_doll.append(board[i][out - 1])
                else:
                    if my_doll[len(my_doll) - 1] == board[i][out - 1]:
                        my_doll = my_doll[:-1]
                        answer += 2
                    else:
                        my_doll.append(board[i][out - 1])
                
                board[i][out - 1] = 0
                break
                   
            
    return answer