# 157339 - 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기

```mysql
SELECT
    CAR.CAR_ID AS CAR_ID,
    CAR.CAR_TYPE AS CAR_TYPE,
    FLOOR(CAR.DAILY_FEE * 30 * (100 - PLAN.DISCOUNT_RATE) / 100) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR AS CAR
        INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS PLAN
                   ON CAR.CAR_TYPE = PLAN.CAR_TYPE AND PLAN.DURATION_TYPE = '30일 이상'
WHERE
      CAR.CAR_TYPE IN ('세단', 'SUV')
  AND CAR.CAR_ID NOT IN (SELECT CAR_ID
                         FROM
                             CAR_RENTAL_COMPANY_RENTAL_HISTORY
                         WHERE
                               START_DATE <= '2022-11-30'
                           AND END_DATE >= '2022-11-01')
  AND CAR.DAILY_FEE * 30 * (100 - PLAN.DISCOUNT_RATE) / 100 BETWEEN 500000 AND 2000000
ORDER BY
    FEE DESC, CAR.CAR_TYPE ASC, CAR.CAR_ID DESC;
```

# 131117 - 5월 식품들의 총매출 조회하기

```mysql
SELECT
    FP.PRODUCT_ID AS PRODUCT_ID,
    FP.PRODUCT_NAME AS PRODUCT_NAME,
    SUM(FP.PRICE * FO.AMOUNT) AS 'TOTAL_SALES'
FROM
    FOOD_PRODUCT AS FP
        LEFT JOIN FOOD_ORDER AS FO ON FP.PRODUCT_ID = FO.PRODUCT_ID
WHERE
    FO.PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY
    FP.PRODUCT_ID
ORDER BY
    SUM(FP.PRICE * FO.AMOUNT) DESC, PRODUCT_ID ASC
```

# 133027 - 주문량이 많은 아이스크림들 조회하기

```mysql
SELECT
    FH.FLAVOR
FROM
    FIRST_HALF FH
        INNER JOIN JULY ON FH.FLAVOR = JULY.FLAVOR
GROUP BY
    FH.FLAVOR
ORDER BY
    SUM(FH.TOTAL_ORDER + JULY.TOTAL_ORDER) DESC
LIMIT 3;
```

# 59042 - 없어진 기록 찾기

```mysql
-- 코드를 입력하세요
SELECT
    AO.ANIMAL_ID AS ANIMAL_ID,
    AO.NAME AS NAME
FROM
    ANIMAL_OUTS AS AO
        LEFT JOIN ANIMAL_INS AS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE
    AI.ANIMAL_ID IS NULL
ORDER BY
    AO.ANIMAL_ID
```

# 131124 - 그룹별 조건에 맞는 식당 목록 출력하기

```mysql
SELECT
    MP.MEMBER_NAME AS MEMBER_NAME,
    RR.REVIEW_TEXT AS REVIEW_TEXT,
    DATE_FORMAT(RR.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM
    MEMBER_PROFILE MP
        LEFT JOIN REST_REVIEW RR ON MP.MEMBER_ID = RR.MEMBER_ID
WHERE
    MP.MEMBER_ID =
    (SELECT MEMBER_ID
     FROM
         REST_REVIEW
     GROUP BY MEMBER_ID
     ORDER BY COUNT(MEMBER_ID) DESC
     LIMIT 1)
ORDER BY
    RR.REVIEW_DATE ASC, RR.REVIEW_TEXT ASC
```

# 276035 - FrontEnd 개발자 찾기

```mysql
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM
    DEVELOPERS
WHERE
    (SELECT 1 <= COUNT(*)
     FROM
         SKILLCODES
     WHERE
           CATEGORY = 'Front End'
       AND SKILL_CODE & CODE)
ORDER BY
    ID ASC
```

# 131534 - 상품을 구매한 회원 비율 구하기

```mysql
SELECT
    YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, COUNT(DISTINCT OS.USER_ID) AS PUCHASED_USERS,
    ROUND(
            COUNT(DISTINCT OS.USER_ID) /
            (SELECT COUNT(*)
             FROM
                 USER_INFO
             WHERE
                 YEAR(JOINED) = 2021), 1) AS PUCHASED_RATIO
FROM
    USER_INFO AS UI
        INNER JOIN ONLINE_SALE AS OS ON UI.USER_ID = OS.USER_ID
WHERE
    YEAR(UI.JOINED) = 2021
GROUP BY
    YEAR, MONTH
ORDER BY
    YEAR, MONTH
```

# 59043 - 있었는데요 없었습니다

```mysql
SELECT
    AI.ANIMAL_ID AS ANIMAL_ID, AI.NAME AS `NAME`
FROM
    ANIMAL_INS AS AI
        LEFT JOIN ANIMAL_OUTS AS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE
    AI.DATETIME > AO.DATETIME
ORDER BY
    AI.DATETIME
```

# 144854 - 조건에 맞는 도서와 저자 리스트 출력하기

```mysql
SELECT
    BOOK.BOOK_ID AS BOOK_ID, AUTHOR.AUTHOR_NAME AS AUTHOR_NAME,
    DATE_FORMAT(BOOK.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM
    BOOK
        JOIN AUTHOR ON BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
WHERE
    BOOK.CATEGORY = '경제'
ORDER BY
    BOOK.PUBLISHED_DATE
```

# 59044 - 오랜 기간 보호한 동물(1)

```mysql
-- 코드를 입력하세요
SELECT
    AI.NAME AS NAME, AI.DATETIME AS DATETIME
FROM
    ANIMAL_INS AS AI
        LEFT JOIN ANIMAL_OUTS AS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE
    AO.DATETIME IS NULL
ORDER BY
    AI.DATETIME ASC
LIMIT 3
```

# 59045 - 보호소에서 중성화한 동물

```mysql
SELECT
    AI.ANIMAL_ID AS ANIMAL_ID, AI.ANIMAL_TYPE AS ANIMAL_TYPE, AI.NAME AS `NAME`
FROM
    ANIMAL_INS AS AI
        LEFT JOIN ANIMAL_OUTS AS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE
      AI.SEX_UPON_INTAKE LIKE 'Intact%'
  AND (AO.SEX_UPON_OUTCOME LIKE 'Spayed%' OR AO.SEX_UPON_OUTCOME LIKE 'Neutered%')
```

# 131533 - 상품 별 오프라인 매출 구하기

```mysql
SELECT
    P.PRODUCT_CODE AS PRODUCT_CODE, SUM(SALES_AMOUNT) * P.PRICE AS SALES
FROM
    PRODUCT AS P
        LEFT JOIN OFFLINE_SALE AS OS ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY
    PRODUCT_CODE
ORDER BY
    SUM(SALES_AMOUNT) * P.PRICE DESC, P.PRODUCT_CODE ASC
```

# 157342 - 자동차 평균 대여 기간 구하기

```mysql
SELECT
    CAR_ID,
    ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY
    CAR_ID
HAVING
    AVERAGE_DURATION >= 7
ORDER BY
    AVERAGE_DURATION DESC, CAR_ID DESC
```

# 164671 - 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기

```mysql
SELECT
    CONCAT('/home/grep/src/', UGB.BOARD_ID, '/', UGF.FILE_ID, UGF.FILE_NAME, UGF.FILE_EXT) AS FILE_PATH
FROM
    USED_GOODS_BOARD UGB
        INNER JOIN USED_GOODS_FILE UGF ON UGB.BOARD_ID = UGF.BOARD_ID
WHERE
    UGB.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY
    UGF.FILE_ID DESC
```

# 151141 - 자동차 대여 기록 별 대여 금액 구하기

```mysql
SELECT
    CRCRH.HISTORY_ID AS HISTORY_ID,
    CASE
        WHEN CRCRH.DURATION_TYPE = '7일 이상' THEN ROUND(
                (100 - CRCDP.DISCOUNT_RATE) / 100 * CRCC.DAILY_FEE * CRCRH.RENT_DATE, 0)
        WHEN CRCRH.DURATION_TYPE = '30일 이상' THEN ROUND(
                (100 - CRCDP.DISCOUNT_RATE) / 100 * CRCC.DAILY_FEE * CRCRH.RENT_DATE, 0)
        WHEN CRCRH.DURATION_TYPE = '90일 이상' THEN ROUND(
                (100 - CRCDP.DISCOUNT_RATE) / 100 * CRCC.DAILY_FEE * CRCRH.RENT_DATE, 0)
        ELSE DAILY_FEE * RENT_DATE
        END AS FEE
FROM
    (SELECT
         HISTORY_ID,
         CAR_ID,
         DATEDIFF(END_DATE, START_DATE) + 1 AS RENT_DATE,
         CASE
             WHEN DATEDIFF(END_DATE, START_DATE) + 1 BETWEEN 7 AND 29 THEN '7일 이상'
             WHEN DATEDIFF(END_DATE, START_DATE) + 1 BETWEEN 30 AND 89 THEN '30일 이상'
             WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90 THEN '90일 이상'
             ELSE ''
             END AS DURATION_TYPE
     FROM
         CAR_RENTAL_COMPANY_RENTAL_HISTORY) AS CRCRH
        LEFT JOIN CAR_RENTAL_COMPANY_CAR AS CRCC
                  ON CRCRH.CAR_ID = CRCC.CAR_ID
        LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS CRCDP
                  ON
                      CRCC.CAR_TYPE = CRCDP.CAR_TYPE AND
                      CRCRH.DURATION_TYPE = CRCDP.DURATION_TYPE
WHERE
    CRCC.CAR_TYPE = '트럭'
ORDER BY
    FEE DESC, HISTORY_ID DESC
```

# 164672 - 조건에 부합하는 중고거래 상태 조회하기

```mysql
SELECT
    BOARD_ID, WRITER_ID, TITLE, PRICE,
    CASE
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
        WHEN STATUS = 'DONE' THEN '거래완료'
        END AS STATUS
FROM
    USED_GOODS_BOARD
WHERE
    DATE_FORMAT(CREATED_DATE, '%Y-%m-%d') = '2022-10-05'
ORDER BY
    BOARD_ID DESC
```

# 157343 - 특정 옵션이 포함된 자동차 리스트 구하기

```mysql
SELECT
    CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
FROM
    CAR_RENTAL_COMPANY_CAR
WHERE
    OPTIONS LIKE '%네비게이션%'
ORDER BY
    CAR_ID DESC
```

# 151138 - 자동차 대여 기록에서 장기/단기 대여 구분하기

```mysql
SELECT
    HISTORY_ID, CAR_ID,
    DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
    DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
    IF(DATEDIFF(END_DATE, START_DATE) + 1 >= 30, '장기 대여', '단기 대여') AS RENT_TYPE
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
    DATE_FORMAT(START_DATE, '%Y-%m') = '2022-09'
ORDER BY
    HISTORY_ID DESC
```

# 131113 - 조건별로 분류하여 주문상태 출력하기

```mysql
SELECT
    ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
    CASE
        WHEN '2022-05-01' >= OUT_DATE
            THEN '출고완료'
        WHEN '2022-05-01' < OUT_DATE
            THEN '출고대기'
        ELSE '출고미정'
        END AS '출고여부'
FROM
    FOOD_ORDER
ORDER BY
    ORDER_ID
```

# 157341 - 대여 기록이 존재하는 자동차 리스트 구하기

```mysql
-- 코드를 입력하세요
SELECT DISTINCT
    CRCC.CAR_ID
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY AS CRCRH
        INNER JOIN CAR_RENTAL_COMPANY_CAR AS CRCC
                   ON CRCRH.CAR_ID = CRCC.CAR_ID
WHERE
      CRCC.CAR_TYPE = '세단'
  AND DATE_FORMAT(CRCRH.START_DATE, '%m') = '10'
ORDER BY
    CRCC.CAR_ID DESC
```

# 164670 - 조건에 맞는 사용자 정보 조회하기

```mysql
SELECT
    UGU.USER_ID AS USER_ID, UGU.NICKNAME AS NICKNAME,
    CONCAT(UGU.CITY, ' ', UGU.STREET_ADDRESS1, ' ', UGU.STREET_ADDRESS2) AS '전체주소',
    CONCAT(SUBSTRING(UGU.TLNO, 1, 3), '-', SUBSTRING(UGU.TLNO, 4, 4), '-', SUBSTRING(UGU.TLNO, 8, 4)) AS '전화번호'
FROM
    USED_GOODS_USER AS UGU
        LEFT JOIN USED_GOODS_BOARD AS UGB ON UGU.USER_ID = UGB.WRITER_ID
GROUP BY
    UGU.USER_ID
HAVING
    COUNT(UGB.BOARD_ID) >= 3
ORDER BY
    UGU.USER_ID DESC
```

# 132204 - 취소되지 않은 진료 예약 조회하기

```mysql
SELECT
    A.APNT_NO AS APNT_NO, P.PT_NAME AS PT_NAME, P.PT_NO AS PT_NO, D.MCDP_CD AS MCDP_CD, D.DR_NAME AS DR_NAME,
    A.APNT_YMD AS APNT_YMD
FROM
    APPOINTMENT AS A
        INNER JOIN DOCTOR AS D ON A.MDDR_ID = D.DR_ID
        INNER JOIN PATIENT AS P ON A.PT_NO = P.PT_NO
WHERE
      DATE_FORMAT(A.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
  AND D.MCDP_CD = 'CS'
  AND A.APNT_CNCL_YN = 'N'
ORDER BY
    A.APNT_YMD ASC
```

# 59046 - 루시와 엘라 찾기

```mysql
SELECT
    ANIMAL_ID, `NAME`, SEX_UPON_INTAKE
FROM
    ANIMAL_INS
WHERE
    NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY
    ANIMAL_ID ASC
```

# 59047 - 이름에 el이 들어가는 동물 찾기

```mysql
SELECT ANIMAL_ID, `NAME`
FROM
    ANIMAL_INS
WHERE
      ANIMAL_TYPE = 'DOG'
  AND `NAME` LIKE '%EL%'
ORDER BY
    NAME ASC
```

# 59409 - 중성화 여부 파악하기

```mysql
SELECT
    ANIMAL_ID, `NAME`,
    IF(SEX_UPON_INTAKE LIKE 'intact %', 'X', 'O') AS '중성화'
FROM
    ANIMAL_INS
```

# 59411 - 오랜 기간 보호한 동물(2)

```mysql
SELECT
    AI.ANIMAL_ID, AI.NAME
FROM
    ANIMAL_INS AS AI
        INNER JOIN ANIMAL_OUTS AS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
ORDER BY
    AO.DATETIME - AI.DATETIME DESC
LIMIT 2
```

# 131529 - 카테고리 별 상품 개수 구하기
```mysql
SELECT
    SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY, COUNT(*) AS PRODUCTS
FROM
    PRODUCT
GROUP BY
    CATEGORY
ORDER BY
    CATEGORY
```