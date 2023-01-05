#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

void point(int *data, char surv, int p) {
    switch(surv) {
        case 'R':
            data[0] += p;
            break;
        case 'T':
            data[1] += p;
            break;
        case 'C':
            data[2] += p;
            break;
        case 'F':
            data[3] += p;
            break;
        case 'J':
            data[4] += p;
            break;
        case 'M':
            data[5] += p;
            break;
        case 'A':
            data[6] += p;
            break;
        case 'N':
            data[7] += p;
            break;
    }
}

// survey_len은 배열 survey의 길이입니다.
// choices_len은 배열 choices의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* survey[], size_t survey_len, int choices[], size_t choices_len) {
    int data[] = {0, 0, 0, 0, 0, 0, 0, 0};
    
    for (int i = 0; i < choices_len; i++) {
        if (choices[i] == 4)    continue;
        if (choices[i] > 4) {
            point(data, survey[i][1], choices[i] - 4);
        } else {
            point(data, survey[i][0], 4 - choices[i]);
        }
    }
    char temp[5];
    if (data[0] >= data[1]) {
        temp[0] = 'R';
    } else {
        temp[0] = 'T';
    }
    if (data[2] >= data[3]) {
        temp[1] = 'C';
    } else {
        temp[1] = 'F';
    }
    if (data[4] >= data[5]) {
        temp[2] = 'J';
    } else {
        temp[2] = 'M';
    }
    if (data[6] >= data[7]) {
        temp[3] = 'A';
    } else {
        temp[3] = 'N';
    }
    
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char *answer = (char *)malloc(sizeof(char) * 5);
    for (int i = 0; i < 4; i++) {
        answer[i] = temp[i];
    }
    answer[4] = 0;
    return answer;
}
