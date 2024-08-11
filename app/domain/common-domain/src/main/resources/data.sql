-- 장르 데이터
INSERT INTO public.genre (id, created_at, updated_at, is_deleted, name)
VALUES ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '락'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '힙합'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '밴드음악'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'J-pop'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '팝'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d6', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '하우스'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d7', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'edm'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d8', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '뮤지컬'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'R&B'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876da', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '오페라'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876db', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '메탈'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876dc', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '클래식'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876dd', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '재즈');

-- 아티스트 데이터
INSERT INTO public.artist (id, created_at, updated_at, is_deleted, korean_name, english_name,
                           gender,
                           type, country, image)
VALUES ('b9f79017-f97d-44b1-82ce-645e92856c0b', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '콜드플레이', 'Coldplay', 'MAN', 'GROUP', 'UK', ''),
       ('ec304557-e9f1-4bf3-8abf-62c83dec099f', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '포스트 말론', 'Post Malone', 'MAN', 'SOLO', 'USA', ''),
       ('977452b5-db8e-48b9-abe6-d06b44a1b4ad', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '이브', 'Eve', 'WOMAN', 'SOLO', 'Japan', ''),
       ('2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '스파이에어', 'Spyair', 'MAN', 'GROUP', 'Japan', ''),
       ('dac4fda7-1746-4eb3-8b87-cab78ae86c75', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '엘르가든', 'Ellegarden', 'MAN', 'GROUP', 'Japan', ''),
       ('d3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '킹누', 'King Gnu', 'MAN', 'GROUP', 'Japan', ''),
       ('f56b52c1-72c2-450c-ad59-e88db1530dcb', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '브루노 마스', 'Bruno Mars', 'MAN', 'SOLO', 'USA', ''),
       ('a94dc17e-4b77-4959-bb1d-a3bd9735cf01', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '찰리 푸스', 'Charlie Puth', 'MAN', 'SOLO', 'USA', ''),
       ('0b60cd2a-5312-41a2-ba1d-db1acb72460b', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '테일러 스위프트', 'Taylor Swift', 'WOMAN', 'SOLO', 'USA', ''),
       ('02c9aedf-9ea2-4720-83c5-eeacd79a2e6e', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '위켄드', 'The Weeknd', 'MAN', 'SOLO', 'Canada', ''),
       ('c3df1fe2-0795-4204-92d6-68d3d6f4bc05', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '저스틴 비버', 'Justin Bieber', 'MAN', 'SOLO', 'Canada', ''),
       ('7a97697e-2fa0-4d5b-851f-dd8864b5b49a', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '올리비아 딘', 'Olivia Dean', 'WOMAN', 'SOLO', 'UK', ''),
       ('fdf9929d-9001-489a-9d7f-a345581ca6bd', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '새미 비르지', 'Sammy Virji', 'MAN', 'SOLO', 'UK', ''),
       ('1535086f-99ff-493e-bfb4-254f15d87e5d', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '디스클로저', 'Disclosure', 'MAN', 'GROUP', 'UK', ''),
       ('f5d0d77a-e5f2-42ff-8478-5a70b3d7ba50', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '라디오헤드', 'Radiohead', 'MAN', 'GROUP', 'UK', ''),
       ('e7bf557b-8591-418f-8422-d1f08c26df2f', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '에이제이알', 'AJR', 'MAN', 'GROUP', 'USA', ''),
       ('e7f28490-8e4c-426b-92fc-fbcb226ea7f7', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '크리스토퍼', 'Christopher', 'MAN', 'SOLO', 'Denmark', ''),
       ('b50a931a-d4f3-4c32-8636-253e4fff45ab', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '스트록스', 'The Strokes', 'MAN', 'GROUP', 'USA', ''),
       ('72cdcdb7-1fed-460d-a316-3988ffa1a6c8', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '벤슨 분', 'Benson Boone', 'MAN', 'SOLO', 'USA', ''),
       ('e86ca40e-29f3-48d3-921f-c51d5e8c05e0', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '아리아나그란데', 'Ariana Grande', 'WOMAN', 'SOLO', 'USA', ''),
       ('6d7fee98-4719-4afc-9113-42177e417cb8', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '코난 그레이', 'Conan Gray', 'MAN', 'SOLO', 'USA', ''),
       ('ac400fd9-d188-4dfa-81a9-80d092317855', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '마룬 5', 'Maroon 5', 'MAN', 'GROUP', 'USA', ''),
       ('8c85815e-cd89-44cf-912d-d8c92a0ace60', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '이메진 드래곤스', 'Imagine Dragons', 'MAN', 'GROUP', 'USA', ''),
       ('1d6bd071-dd58-4411-988b-4a6146f59c80', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '요아소비', 'Yoasobi', 'MIXED', 'GROUP', 'Japan', ''),
       ('f5fc86ee-0519-409c-9bed-ae0dbead3bea', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '라우브', 'Lauv', 'MAN', 'SOLO', 'USA', ''),
       ('db8e5dbb-fc91-48d6-ba0f-0100004a64af', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '레이니', 'Lany', 'MAN', 'GROUP', 'USA', ''),
       ('de7b5c97-16d4-4d0b-bf52-b58f28b5475c', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '혼네', 'Honne', 'MAN', 'GROUP', 'UK', ''),
       ('059f8de8-e3f7-4e3b-a1da-89a8c4b73f70', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '노엘 갤러거 하이플라잉버즈', 'Noel Gallagher`s High Flying Birds', 'MAN', 'GROUP', 'UK', ''),
       ('2c8afe0e-1c1b-4226-b20e-726faa1fc48c', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '그린데이', 'Green Day', 'MAN', 'GROUP', 'USA', ''),
       ('b4e388ca-5a54-4e2e-8624-ddd363b32a75', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '모네스킨', 'Måneskin', 'MIXED', 'GROUP', 'Italy', ''),
       ('e22c3c45-b88b-4278-b20d-270aac64229e', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '유우리', 'Yuuri', 'MAN', 'SOLO', 'Japan', ''),
       ('b6f220ab-34ad-40ee-b797-ec5c24459aa9', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '트래비스', 'Travis', 'MAN', 'GROUP', 'UK', ''),
       ('eb93b4ca-be7c-409f-b48d-5301ee0b02fe', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '머라이어캐리', 'Mariah Carey', 'WOMAN', 'SOLO', 'USA', ''),
       ('43e17c11-c3b7-4dd9-a92e-fdadb8783bca', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '계속 한밤중이면 좋을텐데', 'ZUTOMAYO', 'MIXED', 'GROUP', 'Japan', ''),
       ('fdc16095-1bb1-4cc6-8e2f-75495a6f3a13', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '원오크락', 'ONE OK ROCK', 'MAN', 'GROUP', 'Japan', ''),
       ('2f8c8f6c-842a-48cd-9ed7-f84710d3fef2', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '뉴 호프 클럽', 'New Hope Club', 'MAN', 'GROUP', 'UK', ''),
       ('6b1aeec8-ac19-4a6a-92b5-5e71733ef204', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '마이클부불레', 'Michael Bublé', 'MAN', 'SOLO', 'Canada', ''),
       ('2e277ef0-c3f1-4f80-9ed0-4db0a3350e12', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '저스틴팀버레이크', 'Justin Timberlake', 'MAN', 'SOLO', 'USA', ''),
       ('e0fc0ab6-19ee-47ef-a50d-45ab7efe3bba', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '와니마', 'Wanima', 'MAN', 'GROUP', 'Japan', ''),
       ('772efb86-0af8-4dc6-b73b-bd226fb86944', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '후지이 카제', 'Fujii Kaze', 'MAN', 'SOLO', 'Japan', ''),
       ('268ad7b1-7550-4cab-bb04-273b1649e682', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '레오루', 'Reol', 'WOMAN', 'SOLO', 'Japan', ''),
       ('e3753ac5-a079-417a-b75a-7593d9b802ad', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '정글', 'Jungle', 'MAN', 'GROUP', 'UK', ''),
       ('5aeb15be-b150-4915-a242-d35cdee8aeb4', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '나씽 벗 띠브스', 'Nothing But Thieves', 'MAN', 'GROUP', 'UK', ''),
       ('01681324-678a-4e9a-a80b-e93d038bf75f', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '제이콥 콜리어', 'Jacob Collier', 'MAN', 'SOLO', 'UK', ''),
       ('587d14a8-dc16-47b1-8788-b1860076cbdb', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '노엘갤러거', 'Noel Gallagher', 'MAN', 'SOLO', 'UK', ''),
       ('17790b8d-4e2c-4ec5-a524-d00d80a9868e', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '라나 델 레이', 'Lana Del Rey', 'WOMAN', 'SOLO', 'USA', ''),
       ('88ade2ad-96ac-4ed4-8dce-72aec8d8545d', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '원오트릭스 포인트 네버', 'OPN (Oneohtrix Point Never)', 'MAN', 'SOLO', 'USA', ''),
       ('c440d4e0-3f52-4225-9bc2-f1183a4b9f22', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '코코 앤 클레어 클레어', 'Coco & Clair Clair', 'WOMAN', 'GROUP', 'USA', ''),
       ('036854c0-9d22-4660-89f9-0abd16dd3ec1', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '쿠키 카와이', 'Cookiee Kawaii', 'WOMAN', 'SOLO', 'USA', ''),
       ('e139192f-ba01-4a15-b0b1-86005aee3c1d', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '킹크룰', 'King Krule', 'MAN', 'SOLO', 'UK', ''),
       ('d63490e9-0eaf-4914-be90-8d34381b5b05', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '켄드릭 라마', 'Kendrick Lamar', 'MAN', 'SOLO', 'USA', ''),
       ('56a4a4af-dc3f-4f9f-9316-6bcd20d99455', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '오피셜히게단디즘', 'Official Hige Dandism', 'MAN', 'GROUP', 'Japan', ''),
       ('687f2125-f72e-45c9-84cc-3181fa5af912', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '바운디', 'Vaundy', 'MAN', 'SOLO', 'Japan', ''),
       ('909593a3-d067-4dae-9b4a-e14c8accb1aa', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '나토리', 'Natori', 'MAN', 'SOLO', 'Japan', ''),
       ('10c0c327-8053-4792-ae0b-413d337ec413', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '아도', 'Ado', 'WOMAN', 'SOLO', 'Japan', ''),
       ('e19d1403-c4b3-4a6f-b5b8-8e935cb645c4', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '와누카', 'Wanuka', 'WOMAN', 'SOLO', 'Japan', ''),
       ('80154f71-f7b6-4d06-be39-2e4e00b281a1', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '요네즈 켄시', 'Kenshi Yonezu', 'MAN', 'SOLO', 'Japan', ''),
       ('4fd6cc98-3e3a-42bf-b04d-1563335397ad', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '이마세', 'Imase', 'MAN', 'SOLO', 'Japan', ''),
       ('c89e680f-1f9a-41a0-bc35-b835e67dcace', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '리사', 'LiSA', 'WOMAN', 'SOLO', 'Japan', ''),
       ('2f3532d6-f6f6-4b34-950f-7e4fc701e009', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '아이묭', 'Aimyon', 'WOMAN', 'SOLO', 'Japan', ''),
       ('f636f96a-7a42-416b-bab8-1cb8e1d2c314', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '에메', 'Aimer', 'WOMAN', 'SOLO', 'Japan', ''),
       ('c62a2a56-1723-44f2-abb2-7a344db06afe', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '츠키', 'Tuki.', 'WOMAN', 'SOLO', 'Japan', ''),
       ('6342db02-e3ee-494b-91f0-15ba144b906c', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '히즈치분가쿠', 'Hitsujibungaku', 'WOMAN', 'GROUP', 'Japan', ''),
       ('ec82d1dd-7eb7-4801-bd44-86d6096e4dea', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '밀레니엄 퍼레이드', 'Millennium Parade', 'MAN', 'GROUP', 'Japan', ''),
       ('5adeac70-0723-4869-831c-aace7691412c', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '야마', 'Yama', 'MAN', 'SOLO', 'Japan', ''),
       ('0dcf43ed-2a0c-4a54-af53-40eaa5c33776', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '래드윔프스', 'RADWIMPS', 'MAN', 'GROUP', 'Japan', ''),
       ('340cb74f-c770-43ce-91af-88cd2eff23d9', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '요루시카', 'Yorushika', 'MIXED', 'GROUP', 'Japan', ''),
       ('45c6e260-0ac1-4786-831f-7b077d8192e5', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '미세스 그린 애플', 'Mrs. Green Apple', 'MAN', 'GROUP', 'Japan', ''),
       ('d187b6a2-4923-4611-bfff-f9c4c986566e', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '빌리 아일리시', 'Billie Eilish', 'WOMAN', 'SOLO', 'USA', ''),
       ('5a4db81d-16e8-4033-8198-09bc92f57ca4', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '마이클 볼튼', 'Michael Bolton', 'MAN', 'SOLO', 'USA', ''),
       ('3a2d52b1-b39f-4389-b1ee-a0fc0c38bc62', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '두아리파', 'Dua Lipa', 'WOMAN', 'SOLO', 'UK', ''),
       ('9431dc41-7ce6-4d81-b680-a322595fe43d', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '레드 핫 칠리 페퍼스', 'Red Hot Chili Peppers', 'MAN', 'GROUP', 'USA', ''),
       ('0d38c2cd-0be8-49b5-a719-b17db10afe84', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '아델', 'Adele', 'WOMAN', 'SOLO', 'UK', ''),
       ('9ab800fa-158c-4577-b4a0-15f7df9d641a', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '이매진 드래곤스', 'Imagine Dragons', 'MAN', 'GROUP', 'USA', ''),
       ('8996c8dc-b8a2-449b-9c19-09cd49e2924d', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '에드시런', 'Ed Sheeran', 'MAN', 'SOLO', 'UK', ''),
       ('2204c6fa-c78d-420f-b689-b8932aaf50a7', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '레이디가가', 'Lady Gaga', 'WOMAN', 'SOLO', 'USA', ''),
       ('82311401-6764-44bd-9fb4-a2bb37a89cfd', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '데프 레퍼드', 'Def Leppard', 'MAN', 'GROUP', 'UK', ''),
       ('7b3acbb2-6d90-4bc0-a510-95688ffbdbc7', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '에이씨디씨', 'AC/DC', 'MAN', 'GROUP', 'Australia', ''),
       ('aa4e4067-11cc-46f5-9548-5ebdc40b91a3', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '요니지', 'Yonige', 'WOMAN', 'GROUP', 'Japan', ''),
       ('87228380-e581-46d9-b524-869360451d02', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '녹황색사회', 'Ryokuoushoku Shakai', 'MIXED', 'GROUP', 'Japan', ''),
       ('3d367630-37a4-41be-8d09-4434e4c24d09', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '스티비 원더', 'Stevie Wonder', 'MAN', 'SOLO', 'USA', ''),
       ('967573c3-fcee-453a-b9ee-177359ff7dba', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '호시노 겐', 'Gen Hoshino', 'MAN', 'SOLO', 'Japan', ''),
       ('525c7aec-3c72-45c9-9e53-f904869b1306', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '크리피 넛츠', 'Creepy Nuts', 'MAN', 'GROUP', 'Japan', ''),
       ('b71a2ee4-a110-4e6c-a49c-e135a8311b6b', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '마일리 사이러스', 'Miley Cyrus', 'WOMAN', 'SOLO', 'USA', ''),
       ('1aab6fed-7d20-42ed-9f59-67713671f813', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '베케이션스', 'Vacations', 'MAN', 'GROUP', 'Australia', ''),
       ('129fb608-eeb9-42ec-87f6-e1515bdf2696', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '사카낙션', 'Sakanaction', 'MAN', 'GROUP', 'Japan', '');

-- Coldplay
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b9f79017-f97d-44b1-82ce-645e92856c0b', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b9f79017-f97d-44b1-82ce-645e92856c0b', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b9f79017-f97d-44b1-82ce-645e92856c0b', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Post Malone
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec304557-e9f1-4bf3-8abf-62c83dec099f', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec304557-e9f1-4bf3-8abf-62c83dec099f', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec304557-e9f1-4bf3-8abf-62c83dec099f', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec304557-e9f1-4bf3-8abf-62c83dec099f', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Eve
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '977452b5-db8e-48b9-abe6-d06b44a1b4ad', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '977452b5-db8e-48b9-abe6-d06b44a1b4ad', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- Spyair
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Ellegarden
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'dac4fda7-1746-4eb3-8b87-cab78ae86c75', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'dac4fda7-1746-4eb3-8b87-cab78ae86c75', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'dac4fda7-1746-4eb3-8b87-cab78ae86c75', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- King Gnu
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Bruno Mars
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f56b52c1-72c2-450c-ad59-e88db1530dcb', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f56b52c1-72c2-450c-ad59-e88db1530dcb', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f56b52c1-72c2-450c-ad59-e88db1530dcb', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Charlie Puth
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'a94dc17e-4b77-4959-bb1d-a3bd9735cf01', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'a94dc17e-4b77-4959-bb1d-a3bd9735cf01', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- Taylor Swift
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '0b60cd2a-5312-41a2-ba1d-db1acb72460b', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '0b60cd2a-5312-41a2-ba1d-db1acb72460b', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- The Weeknd
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '02c9aedf-9ea2-4720-83c5-eeacd79a2e6e', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- Justin Bieber
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'c3df1fe2-0795-4204-92d6-68d3d6f4bc05', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'c3df1fe2-0795-4204-92d6-68d3d6f4bc05', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- Olivia Dean
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '7a97697e-2fa0-4d5b-851f-dd8864b5b49a', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Sammy Virji
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'fdf9929d-9001-489a-9d7f-a345581ca6bd', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Disclosure
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '1535086f-99ff-493e-bfb4-254f15d87e5d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d6');

-- Radiohead
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f5d0d77a-e5f2-42ff-8478-5a70b3d7ba50', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f5d0d77a-e5f2-42ff-8478-5a70b3d7ba50', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- AJR
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e7bf557b-8591-418f-8422-d1f08c26df2f', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e7bf557b-8591-418f-8422-d1f08c26df2f', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Christopher
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e7f28490-8e4c-426b-92fc-fbcb226ea7f7', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- The Strokes
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b50a931a-d4f3-4c32-8636-253e4fff45ab', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b50a931a-d4f3-4c32-8636-253e4fff45ab', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Benson Boone
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '72cdcdb7-1fed-460d-a316-3988ffa1a6c8', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Ariana Grande
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e86ca40e-29f3-48d3-921f-c51d5e8c05e0', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e86ca40e-29f3-48d3-921f-c51d5e8c05e0', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- Conan Gray
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '6d7fee98-4719-4afc-9113-42177e417cb8', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Maroon 5
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ac400fd9-d188-4dfa-81a9-80d092317855', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ac400fd9-d188-4dfa-81a9-80d092317855', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ac400fd9-d188-4dfa-81a9-80d092317855', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Imagine Dragons
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '8c85815e-cd89-44cf-912d-d8c92a0ace60', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '8c85815e-cd89-44cf-912d-d8c92a0ace60', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '8c85815e-cd89-44cf-912d-d8c92a0ace60', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Yoasobi
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '1d6bd071-dd58-4411-988b-4a6146f59c80', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Lauv
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f5fc86ee-0519-409c-9bed-ae0dbead3bea', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f5fc86ee-0519-409c-9bed-ae0dbead3bea', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- Lany
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'db8e5dbb-fc91-48d6-ba0f-0100004a64af', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'db8e5dbb-fc91-48d6-ba0f-0100004a64af', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Honne
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'de7b5c97-16d4-4d0b-bf52-b58f28b5475c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'de7b5c97-16d4-4d0b-bf52-b58f28b5475c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Noel Gallagher's High Flying Birds
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '059f8de8-e3f7-4e3b-a1da-89a8c4b73f70', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '059f8de8-e3f7-4e3b-a1da-89a8c4b73f70', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Green Day
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2c8afe0e-1c1b-4226-b20e-726faa1fc48c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2c8afe0e-1c1b-4226-b20e-726faa1fc48c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Måneskin
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b4e388ca-5a54-4e2e-8624-ddd363b32a75', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b4e388ca-5a54-4e2e-8624-ddd363b32a75', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Yuuri
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e22c3c45-b88b-4278-b20d-270aac64229e', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e22c3c45-b88b-4278-b20d-270aac64229e', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Travis
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b6f220ab-34ad-40ee-b797-ec5c24459aa9', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b6f220ab-34ad-40ee-b797-ec5c24459aa9', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Mariah Carey
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'eb93b4ca-be7c-409f-b48d-5301ee0b02fe', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'eb93b4ca-be7c-409f-b48d-5301ee0b02fe', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'eb93b4ca-be7c-409f-b48d-5301ee0b02fe', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2');

-- ZUTOMAYO
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '43e17c11-c3b7-4dd9-a92e-fdadb8783bca', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '43e17c11-c3b7-4dd9-a92e-fdadb8783bca', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '43e17c11-c3b7-4dd9-a92e-fdadb8783bca', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '43e17c11-c3b7-4dd9-a92e-fdadb8783bca', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '43e17c11-c3b7-4dd9-a92e-fdadb8783bca', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- ONE OK ROCK
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'fdc16095-1bb1-4cc6-8e2f-75495a6f3a13', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'fdc16095-1bb1-4cc6-8e2f-75495a6f3a13', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- New Hope Club
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2f8c8f6c-842a-48cd-9ed7-f84710d3fef2', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2f8c8f6c-842a-48cd-9ed7-f84710d3fef2', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2f8c8f6c-842a-48cd-9ed7-f84710d3fef2', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Michael Bublé
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '6b1aeec8-ac19-4a6a-92b5-5e71733ef204', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '6b1aeec8-ac19-4a6a-92b5-5e71733ef204', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876dd');

-- Justin Timberlake
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2e277ef0-c3f1-4f80-9ed0-4db0a3350e12', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2e277ef0-c3f1-4f80-9ed0-4db0a3350e12', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Wanima
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e0fc0ab6-19ee-47ef-a50d-45ab7efe3bba', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e0fc0ab6-19ee-47ef-a50d-45ab7efe3bba', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e0fc0ab6-19ee-47ef-a50d-45ab7efe3bba', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Fujii Kaze
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '772efb86-0af8-4dc6-b73b-bd226fb86944', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '772efb86-0af8-4dc6-b73b-bd226fb86944', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '772efb86-0af8-4dc6-b73b-bd226fb86944', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Reol
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '268ad7b1-7550-4cab-bb04-273b1649e682', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d7'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '268ad7b1-7550-4cab-bb04-273b1649e682', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Jungle
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e3753ac5-a079-417a-b75a-7593d9b802ad', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Nothing But Thieves
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '5aeb15be-b150-4915-a242-d35cdee8aeb4', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '5aeb15be-b150-4915-a242-d35cdee8aeb4', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Jacob Collier
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '01681324-678a-4e9a-a80b-e93d038bf75f', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876dd');

-- Noel Gallagher
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '587d14a8-dc16-47b1-8788-b1860076cbdb', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Lana Del Rey
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '17790b8d-4e2c-4ec5-a524-d00d80a9868e', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '17790b8d-4e2c-4ec5-a524-d00d80a9868e', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Oneohtrix Point Never
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '88ade2ad-96ac-4ed4-8dce-72aec8d8545d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Coco & Clair Clair
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'c440d4e0-3f52-4225-9bc2-f1183a4b9f22', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Cookiee Kawaii
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '036854c0-9d22-4660-89f9-0abd16dd3ec1', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- King Krule
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e139192f-ba01-4a15-b0b1-86005aee3c1d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e139192f-ba01-4a15-b0b1-86005aee3c1d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876dd'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e139192f-ba01-4a15-b0b1-86005aee3c1d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2');

-- Kendrick Lamar
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'd63490e9-0eaf-4914-be90-8d34381b5b05', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2');

-- Official Hige Dandism
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '56a4a4af-dc3f-4f9f-9316-6bcd20d99455', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '56a4a4af-dc3f-4f9f-9316-6bcd20d99455', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '56a4a4af-dc3f-4f9f-9316-6bcd20d99455', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Vaundy
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '687f2125-f72e-45c9-84cc-3181fa5af912', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '687f2125-f72e-45c9-84cc-3181fa5af912', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2');

-- Natori
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '909593a3-d067-4dae-9b4a-e14c8accb1aa', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Ado
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '10c0c327-8053-4792-ae0b-413d337ec413', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Wanuka
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'e19d1403-c4b3-4a6f-b5b8-8e935cb645c4', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Kenshi Yonezu
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '80154f71-f7b6-4d06-be39-2e4e00b281a1', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Imase
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '4fd6cc98-3e3a-42bf-b04d-1563335397ad', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- LiSA
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'c89e680f-1f9a-41a0-bc35-b835e67dcace', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'c89e680f-1f9a-41a0-bc35-b835e67dcace', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Aimyon
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2f3532d6-f6f6-4b34-950f-7e4fc701e009', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2f3532d6-f6f6-4b34-950f-7e4fc701e009', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Aimer
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'f636f96a-7a42-416b-bab8-1cb8e1d2c314', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Tuki.
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'c62a2a56-1723-44f2-abb2-7a344db06afe', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Hitsujibungaku
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '6342db02-e3ee-494b-91f0-15ba144b906c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '6342db02-e3ee-494b-91f0-15ba144b906c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '6342db02-e3ee-494b-91f0-15ba144b906c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Millennium Parade
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec82d1dd-7eb7-4801-bd44-86d6096e4dea', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec82d1dd-7eb7-4801-bd44-86d6096e4dea', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec82d1dd-7eb7-4801-bd44-86d6096e4dea', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'ec82d1dd-7eb7-4801-bd44-86d6096e4dea', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Yama
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '5adeac70-0723-4869-831c-aace7691412c', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- RADWIMPS
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '0dcf43ed-2a0c-4a54-af53-40eaa5c33776', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '0dcf43ed-2a0c-4a54-af53-40eaa5c33776', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '0dcf43ed-2a0c-4a54-af53-40eaa5c33776', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Yorushika
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '340cb74f-c770-43ce-91af-88cd2eff23d9', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '340cb74f-c770-43ce-91af-88cd2eff23d9', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '340cb74f-c770-43ce-91af-88cd2eff23d9', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Mrs. Green Apple
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '45c6e260-0ac1-4786-831f-7b077d8192e5', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '45c6e260-0ac1-4786-831f-7b077d8192e5', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '45c6e260-0ac1-4786-831f-7b077d8192e5', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Billie Eilish
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'd187b6a2-4923-4611-bfff-f9c4c986566e', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'd187b6a2-4923-4611-bfff-f9c4c986566e', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Michael Bolton
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '5a4db81d-16e8-4033-8198-09bc92f57ca4', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '5a4db81d-16e8-4033-8198-09bc92f57ca4', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Dua Lipa
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '3a2d52b1-b39f-4389-b1ee-a0fc0c38bc62', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Red Hot Chili Peppers
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '9431dc41-7ce6-4d81-b680-a322595fe43d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '9431dc41-7ce6-4d81-b680-a322595fe43d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Adele
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '0d38c2cd-0be8-49b5-a719-b17db10afe84', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '0d38c2cd-0be8-49b5-a719-b17db10afe84', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9');

-- Ed Sheeran
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '8996c8dc-b8a2-449b-9c19-09cd49e2924d', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Lady Gaga
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '2204c6fa-c78d-420f-b689-b8932aaf50a7', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Def Leppard
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '82311401-6764-44bd-9fb4-a2bb37a89cfd', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '82311401-6764-44bd-9fb4-a2bb37a89cfd', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876db'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '82311401-6764-44bd-9fb4-a2bb37a89cfd', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- AC/DC
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '7b3acbb2-6d90-4bc0-a510-95688ffbdbc7', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876db'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '7b3acbb2-6d90-4bc0-a510-95688ffbdbc7', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '7b3acbb2-6d90-4bc0-a510-95688ffbdbc7', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1');

-- Yonige
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'aa4e4067-11cc-46f5-9548-5ebdc40b91a3', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'aa4e4067-11cc-46f5-9548-5ebdc40b91a3', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Ryokuoushoku Shakai
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '87228380-e581-46d9-b524-869360451d02', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '87228380-e581-46d9-b524-869360451d02', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3');

-- Stevie Wonder
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '3d367630-37a4-41be-8d09-4434e4c24d09', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Gen Hoshino
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '967573c3-fcee-453a-b9ee-177359ff7dba', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Creepy Nuts
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '525c7aec-3c72-45c9-9e53-f904869b1306', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- Miley Cyrus
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'b71a2ee4-a110-4e6c-a49c-e135a8311b6b', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- Vacations
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '1aab6fed-7d20-42ed-9f59-67713671f813', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5'),
       (gen_random_uuid(), '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        '129fb608-eeb9-42ec-87f6-e1515bdf2696', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4');

-- ArtistSearch

INSERT INTO artist_search (id, created_at, updated_at, is_deleted, name, artist_id)
VALUES (gen_random_uuid(),
        now(),
        now(),
        False,
        '콜드플레이',
        'b9f79017-f97d-44b1-82ce-645e92856c0b'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        'coldplay',
        'b9f79017-f97d-44b1-82ce-645e92856c0b'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        '포스트말론',
        'ec304557-e9f1-4bf3-8abf-62c83dec099f'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        'postmalone',
        'ec304557-e9f1-4bf3-8abf-62c83dec099f'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        '이브',
        '977452b5-db8e-48b9-abe6-d06b44a1b4ad'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        'eve',
        '977452b5-db8e-48b9-abe6-d06b44a1b4ad'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        '브루노마스',
        'f56b52c1-72c2-450c-ad59-e88db1530dcb'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        'brunomars',
        'f56b52c1-72c2-450c-ad59-e88db1530dcb'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        '킹누',
        'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6'),
       (gen_random_uuid(),
        now(),
        now(),
        False,
        'kinggnu',
        'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6');

-- Show
INSERT INTO show(id, created_at, updated_at, is_deleted, title, content, start_date, end_date,
                 location, image, last_ticketing_at, view_count, seat_prices, ticketing_sites)
VALUES ('eca21e50-1392-4059-b380-061a2323c6d2',
        now(),
        now(),
        false,
        '공연제목',
        '공연내용',
        now(),
        now(),
        '공연장 위치',
        'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg',
        now(),
        0,
        '{"b": 20000, "c": 30000}',
        '{"티켓링크": "https://naver.com"}');

-- Show Artist
INSERT INTO show_artist (id, created_at, updated_at, is_deleted, show_id, artist_id)
VALUES (
    gen_random_uuid(),
        now(),
        now(),
        false,
        'eca21e50-1392-4059-b380-061a2323c6d2',
        'b9f79017-f97d-44b1-82ce-645e92856c0b'
       );

-- Show Genre
INSERT INTO show_genre (id, created_at, updated_at, is_deleted, show_id, genre_id)
VALUES (
        gen_random_uuid(),
        now(),
        now(),
        false,
        'eca21e50-1392-4059-b380-061a2323c6d2',
        '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3'
       );

INSERT INTO show_ticketing_time (id, created_at, updated_at, is_deleted, type, ticketing_at, show_id)
VALUES (
        gen_random_uuid(),
        now(),
        now(),
        false,
        'PRE',
        now(),
        'eca21e50-1392-4059-b380-061a2323c6d2'
       );