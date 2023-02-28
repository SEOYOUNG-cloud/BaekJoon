{\rtf1\ansi\ansicpg949\cocoartf2636
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset129 AppleSDGothicNeo-Regular;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.util.*;\
import java.io.*;\
\
class Solution \{\
    \
    static int emoticonsCnt;\
    static int userCnt;\
    static int[][] userss;\
    static int[] emoticonss;\
    static int[] discount;\
        \
    static int[] discountRate = \{10, 20, 30, 40\};\
    \
    public int[] solution(int[][] users, int[] emoticons) \{\
        emoticonsCnt = emoticons.length;\
        userCnt = users.length;\
        discount = new int[emoticonsCnt];\
        userss = users;\
        emoticonss = emoticons;\
        // 1. 
\f1 \'c1\'df\'ba\'b9\'bc\'f8\'bf\'ad
\f0  
\f1 \'b1\'b8\'c7\'cf\'b1\'e2
\f0 \
        permutation(0);\
        \
        \
        return answer;\
        \
    \}\
    \
    private static void permutation(int cnt)\{\
        if(cnt == emoticonsCnt)\{\
            // 
\f1 \'c7\'d8\'b4\'e7
\f0  
\f1 \'c0\'da\'b8\'ae
\f0  
\f1 \'c0\'cc\'b8\'f0\'c6\'bc\'c4\'dc\'c0\'c7
\f0  
\f1 \'c7\'d2\'c0\'ce\'c0\'b2\'c0\'bb
\f0  
\f1 \'b1\'b8\'c7\'df\'c0\'bd
\f0 \
            // 2. 
\f1 \'bb\'e7\'bf\'eb\'c0\'da\'b0\'a1
\f0  
\f1 \'b1\'b8\'b8\'c5\'c7\'d2
\f0  
\f1 \'c0\'cc\'b8\'f0\'c6\'bc\'c4\'dc
\f0  
\f1 \'c8\'ae\'c0\'ce
\f0 \
            checkUserBuy(discount);\
            return;\
        \}\
        \
        for(int i=0; i<4; i++)\{\
            discount[cnt] = discountRate[i];\
            permutation(cnt+1);\
        \}\
    \}\
    \
    static int[] answer = new int[2];\
    private static void checkUserBuy(int[] discount)\{\
        int ePlus = 0;\
        int eTotalPrice = 0;\
        \
        for(int u=0; u<userCnt; u++)\{ // 
\f1 \'c0\'af\'c0\'fa
\f0  
\f1 \'c7\'d1\'b8\'ed\'b4\'e7
\f0 \
            int uRate = userss[u][0]; // 
\f1 \'c0\'af\'c0\'fa\'b0\'a1
\f0  
\f1 \'bb\'ec\'b8\'b8\'c7\'d1
\f0  
\f1 \'c7\'d2\'c0\'ce\'c0\'b2
\f0 \
            int uPrice = userss[u][1]; // 
\f1 \'c0\'af\'c0\'fa\'b0\'a1
\f0  
\f1 \'b0\'a1\'c1\'f8
\f0  
\f1 \'b5\'b7
\f0 \
            \
            int userTotalPrice = 0; // 
\f1 \'c0\'af\'c0\'fa\'b0\'a1
\f0  
\f1 \'bb\'e7\'bf\'eb\'c7\'d2
\f0  
\f1 \'b5\'b7
\f0 \
            for(int e=0; e<emoticonsCnt; e++)\{\
                int dRate = discount[e]; // 
\f1 \'c0\'cc\'b8\'f0\'c6\'bc\'c4\'dc
\f0  
\f1 \'c7\'d2\'c0\'ce\'c0\'b2
\f0 \
                \
                // 
\f1 \'c7\'d2\'c0\'ce\'c0\'b2\'c0\'cc
\f0  
\f1 \'c0\'af\'c0\'fa\'b0\'a1
\f0  
\f1 \'bb\'ec\'b8\'b8\'c7\'d1
\f0  
\f1 \'c7\'d2\'c0\'ce\'c0\'b2\'ba\'b8\'b4\'d9
\f0  
\f1 \'c5\'a9\'b8\'e9
\f0  
\f1 \'bb\'ea\'b4\'d9
\f0 .\
                if(dRate >= uRate) \{\
                    int ePrice = emoticonss[e] * (100 - dRate) / 100;\
                    userTotalPrice += ePrice;\
                \}\
            \}\
            \
            // 
\f1 \'c0\'af\'c0\'fa\'b0\'a1
\f0  
\f1 \'bb\'e7\'b7\'c1\'b4\'c2
\f0  
\f1 \'c3\'d1
\f0  
\f1 \'b1\'dd\'be\'d7\'c0\'cc
\f0  
\f1 \'b0\'a1\'c1\'f8
\f0  
\f1 \'b5\'b7
\f0  
\f1 \'c0\'cc\'bb\'f3\'c0\'cc\'b6\'f3\'b8\'e9
\f0  
\f1 \'c0\'cc\'b8\'f0\'c6\'bc\'c4\'dc
\f0  
\f1 \'c7\'c3\'b7\'af\'bd\'ba\'b8\'a6
\f0  
\f1 \'bb\'ea\'b4\'d9
\f0 .\
            if(userTotalPrice >= uPrice)\{\
                ePlus += 1;\
            \} else\{ // 
\f1 \'be\'c6\'b4\'cf\'b6\'f3\'b8\'e9
\f0  
\f1 \'b1\'d7\'b3\'c9
\f0  
\f1 \'c0\'cc\'b8\'f0\'c6\'bc\'c4\'dc\'c0\'bb
\f0  
\f1 \'bb\'ea\'b4\'d9
\f0 .\
                eTotalPrice += userTotalPrice;\
            \}\
        \}\
        \
        if(ePlus > answer[0])\{\
            answer[0] = ePlus;\
            answer[1] = eTotalPrice;\
        \} else if(ePlus == answer[0] && eTotalPrice > answer[1])\{\
            answer[1] = eTotalPrice;\
        \}\
    \}\
\}}