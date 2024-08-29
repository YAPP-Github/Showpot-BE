-- 장르 데이터
INSERT INTO public.genre (id, created_at, updated_at, is_deleted, name)
VALUES ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'rock'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'hiphop'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'band'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'jpop'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'pop'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d6', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'house'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d7', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'edm'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d8', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'musical'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'rnb'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876da', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'opera'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876db', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'metal'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876dc', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'classic'),
       ('017f20d0-4f3c-8f4d-9e15-7ff0c3a876dd', '2024-08-04 00:00:00', '2024-08-04 00:00:00', false,
        'jazz');

-- 아티스트 데이터
insert into public.artist (id, created_at, updated_at, is_deleted, korean_name, english_name, gender, type, country, image)
values  ('2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', '2024-08-04 00:00:00.000', '2024-08-27 23:25:28.383', false, '스파이에어', 'Spyair', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Spyair_1724768728012.jpg'),
        ('d3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '2024-08-04 00:00:00.000', '2024-08-27 23:26:32.865', false, '킹누', 'King Gnu', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/kingnu_1724768792711.webp'),
        ('f56b52c1-72c2-450c-ad59-e88db1530dcb', '2024-08-04 00:00:00.000', '2024-08-27 23:27:01.420', false, '브루노 마스', 'Bruno Mars', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/bruno_1724768820768.webp'),
        ('a94dc17e-4b77-4959-bb1d-a3bd9735cf01', '2024-08-04 00:00:00.000', '2024-08-27 23:27:26.441', false, '찰리 푸스', 'Charlie Puth', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/chalie_1724768846279.jpg'),
        ('0b60cd2a-5312-41a2-ba1d-db1acb72460b', '2024-08-04 00:00:00.000', '2024-08-27 23:28:06.001', false, '테일러 스위프트', 'Taylor Swift', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/tailer_1724768885797.jpg'),
        ('02c9aedf-9ea2-4720-83c5-eeacd79a2e6e', '2024-08-04 00:00:00.000', '2024-08-27 23:28:32.443', false, '위켄드', 'The Weeknd', 'MAN', 'SOLO', 'Canada', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/weekend_1724768912290.jpg'),
        ('c3df1fe2-0795-4204-92d6-68d3d6f4bc05', '2024-08-04 00:00:00.000', '2024-08-27 23:28:58.454', false, '저스틴 비버', 'Justin Bieber', 'MAN', 'SOLO', 'Canada', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/justin_1724768938125.webp'),
        ('7a97697e-2fa0-4d5b-851f-dd8864b5b49a', '2024-08-04 00:00:00.000', '2024-08-27 23:29:25.163', false, '올리비아 딘', 'Olivia Dean', 'WOMAN', 'SOLO', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/olivia_1724768965040.jpeg'),
        ('fdf9929d-9001-489a-9d7f-a345581ca6bd', '2024-08-04 00:00:00.000', '2024-08-27 23:30:18.118', false, '새미 비르지', 'Sammy Virji', 'MAN', 'SOLO', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/sammy_1724769017908.jpeg'),
        ('1535086f-99ff-493e-bfb4-254f15d87e5d', '2024-08-04 00:00:00.000', '2024-08-27 23:31:13.574', false, '디스클로저', 'Disclosure', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/disclosure_1724769073426.avif'),
        ('f5d0d77a-e5f2-42ff-8478-5a70b3d7ba50', '2024-08-04 00:00:00.000', '2024-08-27 23:31:38.363', false, '라디오헤드', 'Radiohead', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/radio_1724769097990.webp'),
        ('e7bf557b-8591-418f-8422-d1f08c26df2f', '2024-08-04 00:00:00.000', '2024-08-27 23:32:05.516', false, '에이제이알', 'AJR', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/ajr_1724769125314.webp'),
        ('e7f28490-8e4c-426b-92fc-fbcb226ea7f7', '2024-08-04 00:00:00.000', '2024-08-27 23:32:33.585', false, '크리스토퍼', 'Christopher', 'MAN', 'SOLO', 'Denmark', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Christopher_1724769153407.jpg'),
        ('b50a931a-d4f3-4c32-8636-253e4fff45ab', '2024-08-04 00:00:00.000', '2024-08-27 23:33:10.179', false, '스트록스', 'The Strokes', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/stroke_1724769189974.jpg'),
        ('72cdcdb7-1fed-460d-a316-3988ffa1a6c8', '2024-08-04 00:00:00.000', '2024-08-27 23:33:35.371', false, '벤슨 분', 'Benson Boone', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/benson_1724769215187.jpg'),
        ('e86ca40e-29f3-48d3-921f-c51d5e8c05e0', '2024-08-04 00:00:00.000', '2024-08-27 23:34:01.277', false, '아리아나 그란데', 'Ariana Grande', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/ariana_1724769241119.webp'),
        ('6d7fee98-4719-4afc-9113-42177e417cb8', '2024-08-04 00:00:00.000', '2024-08-27 23:34:36.105', false, '코난 그레이', 'Conan Gray', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/connan_1724769275864.jpeg'),
        ('ac400fd9-d188-4dfa-81a9-80d092317855', '2024-08-04 00:00:00.000', '2024-08-27 23:35:06.166', false, '마룬 5', 'Maroon 5', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/marron_1724769305988.jpg'),
        ('8c85815e-cd89-44cf-912d-d8c92a0ace60', '2024-08-04 00:00:00.000', '2024-08-27 23:35:39.227', false, '이메진 드래곤스', 'Imagine Dragons', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/imagine_1724769339017.jpg'),
        ('1d6bd071-dd58-4411-988b-4a6146f59c80', '2024-08-04 00:00:00.000', '2024-08-27 23:36:26.412', false, '요아소비', 'Yoasobi', 'MIXED', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/yoasobi_1724769386223.jpg'),
        ('f5fc86ee-0519-409c-9bed-ae0dbead3bea', '2024-08-04 00:00:00.000', '2024-08-27 23:36:49.897', false, '라우브', 'Lauv', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/lauv_1724769409619.jpeg'),
        ('db8e5dbb-fc91-48d6-ba0f-0100004a64af', '2024-08-04 00:00:00.000', '2024-08-27 23:37:20.852', false, '레이니', 'Lany', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/lany_1724769440725.webp'),
        ('de7b5c97-16d4-4d0b-bf52-b58f28b5475c', '2024-08-04 00:00:00.000', '2024-08-27 23:37:41.800', false, '혼네', 'Honne', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/honne_1724769461626.webp'),
        ('059f8de8-e3f7-4e3b-a1da-89a8c4b73f70', '2024-08-04 00:00:00.000', '2024-08-27 23:38:15.813', false, '노엘 갤러거 하이플라잉버즈', 'Noel Gallagher`s High Flying Birds', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/noel_1724769495678.jpeg'),
        ('2c8afe0e-1c1b-4226-b20e-726faa1fc48c', '2024-08-04 00:00:00.000', '2024-08-27 23:38:38.828', false, '그린데이', 'Green Day', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/green_1724769518692.jpeg'),
        ('b4e388ca-5a54-4e2e-8624-ddd363b32a75', '2024-08-04 00:00:00.000', '2024-08-27 23:39:03.800', false, '모네스킨', 'Måneskin', 'MIXED', 'GROUP', 'Italy', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/maneskin_1724769543598.jpeg'),
        ('e22c3c45-b88b-4278-b20d-270aac64229e', '2024-08-04 00:00:00.000', '2024-08-27 23:39:36.774', false, '유우리', 'Yuuri', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/yuuri_1724769576549.webp'),
        ('b6f220ab-34ad-40ee-b797-ec5c24459aa9', '2024-08-04 00:00:00.000', '2024-08-27 23:40:15.307', false, '트래비스', 'Travis', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/travis_1724769615152.webp'),
        ('eb93b4ca-be7c-409f-b48d-5301ee0b02fe', '2024-08-04 00:00:00.000', '2024-08-27 23:40:45.149', false, '머라이어 캐리', 'Mariah Carey', 'WOMAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/mariah_1724769644975.jpg'),
        ('43e17c11-c3b7-4dd9-a92e-fdadb8783bca', '2024-08-04 00:00:00.000', '2024-08-27 23:41:20.178', false, '계속 한밤중이면 좋을텐데', 'ZUTOMAYO', 'MIXED', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/zutomayo_1724769679969.jpg'),
        ('fdc16095-1bb1-4cc6-8e2f-75495a6f3a13', '2024-08-04 00:00:00.000', '2024-08-27 23:41:43.231', false, '원오크락', 'ONE OK ROCK', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/oneokrock_1724769703056.jpg'),
        ('2f8c8f6c-842a-48cd-9ed7-f84710d3fef2', '2024-08-04 00:00:00.000', '2024-08-27 23:42:17.031', false, '뉴 호프 클럽', 'New Hope Club', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/new_1724769736830.jpg'),
        ('6b1aeec8-ac19-4a6a-92b5-5e71733ef204', '2024-08-04 00:00:00.000', '2024-08-27 23:43:09.597', false, '마이클 부불레', 'Michael Bublé', 'MAN', 'SOLO', 'Canada', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/buble_1724769789357.jpg'),
        ('2e277ef0-c3f1-4f80-9ed0-4db0a3350e12', '2024-08-04 00:00:00.000', '2024-08-27 23:43:46.668', false, '저스틴 팀버레이크', 'Justin Timberlake', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/justin_1724769826408.png'),
        ('e0fc0ab6-19ee-47ef-a50d-45ab7efe3bba', '2024-08-04 00:00:00.000', '2024-08-27 23:44:15.233', false, '와니마', 'Wanima', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/wanima_1724769854792.png'),
        ('772efb86-0af8-4dc6-b73b-bd226fb86944', '2024-08-04 00:00:00.000', '2024-08-27 23:44:38.306', false, '후지이 카제', 'Fujii Kaze', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/fujii_1724769878117.jpeg'),
        ('268ad7b1-7550-4cab-bb04-273b1649e682', '2024-08-04 00:00:00.000', '2024-08-27 23:44:59.151', false, '레오루', 'Reol', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/reol_1724769899019.webp'),
        ('e3753ac5-a079-417a-b75a-7593d9b802ad', '2024-08-04 00:00:00.000', '2024-08-27 23:45:33.511', false, '정글', 'Jungle', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/jungle_1724769933371.jpeg'),
        ('5aeb15be-b150-4915-a242-d35cdee8aeb4', '2024-08-04 00:00:00.000', '2024-08-27 23:45:59.153', false, '나씽 벗 띠브스', 'Nothing But Thieves', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/nothing_1724769958966.jpg'),
        ('01681324-678a-4e9a-a80b-e93d038bf75f', '2024-08-04 00:00:00.000', '2024-08-27 23:46:27.159', false, '제이콥 콜리어', 'Jacob Collier', 'MAN', 'SOLO', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/jacob_1724769986891.jpg'),
        ('9ab800fa-158c-4577-b4a0-15f7df9d641a', '2024-08-04 00:00:00.000', '2024-08-04 00:00:00.000', false, '이매진 드래곤스', 'Imagine Dragons', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/images_1724739402299.jpeg'),
        ('b9f79017-f97d-44b1-82ce-645e92856c0b', '2024-08-04 00:00:00.000', '2024-08-27 23:19:11.253', false, '콜드플레이', 'Coldplay', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/%E1%84%8F%E1%85%A9%E1%86%AF%E1%84%83%E1%85%B3_1724768351050.webp'),
        ('88ade2ad-96ac-4ed4-8dce-72aec8d8545d', '2024-08-04 00:00:00.000', '2024-08-27 23:48:17.537', false, '원오트릭스 포인트 네버', 'OPN (Oneohtrix Point Never)', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/opn_1724770097381.webp'),
        ('c440d4e0-3f52-4225-9bc2-f1183a4b9f22', '2024-08-04 00:00:00.000', '2024-08-27 23:48:44.750', false, '코코 앤 클레어 클레어', 'Coco & Clair Clair', 'WOMAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/coco_1724770123547.jpeg'),
        ('036854c0-9d22-4660-89f9-0abd16dd3ec1', '2024-08-04 00:00:00.000', '2024-08-27 23:49:12.096', false, '쿠키 카와이', 'Cookiee Kawaii', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/cookiee_1724770151991.jpeg'),
        ('e139192f-ba01-4a15-b0b1-86005aee3c1d', '2024-08-04 00:00:00.000', '2024-08-27 23:49:41.936', false, '킹크룰', 'King Krule', 'MAN', 'SOLO', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/king_1724770181258.jpg'),
        ('d63490e9-0eaf-4914-be90-8d34381b5b05', '2024-08-04 00:00:00.000', '2024-08-27 23:50:10.349', false, '켄드릭 라마', 'Kendrick Lamar', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/kendric_1724770210212.jpeg'),
        ('56a4a4af-dc3f-4f9f-9316-6bcd20d99455', '2024-08-04 00:00:00.000', '2024-08-27 23:50:40.608', false, '오피셜히게단디즘', 'Official Hige Dandism', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/official_1724770240501.jpeg'),
        ('687f2125-f72e-45c9-84cc-3181fa5af912', '2024-08-04 00:00:00.000', '2024-08-27 23:51:07.598', false, '바운디', 'Vaundy', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/vaundy_1724770267470.webp'),
        ('909593a3-d067-4dae-9b4a-e14c8accb1aa', '2024-08-04 00:00:00.000', '2024-08-27 23:51:36.354', false, '나토리', 'Natori', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/natori_1724770296144.jpg'),
        ('10c0c327-8053-4792-ae0b-413d337ec413', '2024-08-04 00:00:00.000', '2024-08-27 23:52:00.472', false, '아도', 'Ado', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/ado_1724770320291.jpeg'),
        ('e19d1403-c4b3-4a6f-b5b8-8e935cb645c4', '2024-08-04 00:00:00.000', '2024-08-27 23:52:37.894', false, '와누카', 'Wanuka', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/wanuka_1724770357742.webp'),
        ('80154f71-f7b6-4d06-be39-2e4e00b281a1', '2024-08-04 00:00:00.000', '2024-08-27 23:53:08.584', false, '요네즈 켄시', 'Kenshi Yonezu', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/kenshi-yonezu-album_1724770388385.jpg'),
        ('4fd6cc98-3e3a-42bf-b04d-1563335397ad', '2024-08-04 00:00:00.000', '2024-08-27 23:53:30.731', false, '이마세', 'Imase', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/imase_1724770410488.webp'),
        ('c89e680f-1f9a-41a0-bc35-b835e67dcace', '2024-08-04 00:00:00.000', '2024-08-27 23:54:01.842', false, '리사', 'LiSA', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/lisa_1724770439260.jpg'),
        ('2f3532d6-f6f6-4b34-950f-7e4fc701e009', '2024-08-04 00:00:00.000', '2024-08-27 23:54:38.360', false, '아이묭', 'Aimyon', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/aimyon_1724770477849.webp'),
        ('f636f96a-7a42-416b-bab8-1cb8e1d2c314', '2024-08-04 00:00:00.000', '2024-08-27 23:55:30.235', false, '에메', 'Aimer', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/aimer_1724770530046.webp'),
        ('c62a2a56-1723-44f2-abb2-7a344db06afe', '2024-08-04 00:00:00.000', '2024-08-27 23:57:07.330', false, '츠키', 'Tuki.', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/tuki_1724770627159.jpg'),
        ('6342db02-e3ee-494b-91f0-15ba144b906c', '2024-08-04 00:00:00.000', '2024-08-27 23:57:37.254', false, '히즈치분가쿠', 'Hitsujibungaku', 'WOMAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Hitsujibungaku_1724770657102.webp'),
        ('ec82d1dd-7eb7-4801-bd44-86d6096e4dea', '2024-08-04 00:00:00.000', '2024-08-27 23:58:20.611', false, '밀레니엄 퍼레이드', 'Millennium Parade', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/mille_1724770700428.webp'),
        ('5adeac70-0723-4869-831c-aace7691412c', '2024-08-04 00:00:00.000', '2024-08-27 23:58:50.153', false, '야마', 'Yama', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/yama_1724770729949.jpeg'),
        ('0dcf43ed-2a0c-4a54-af53-40eaa5c33776', '2024-08-04 00:00:00.000', '2024-08-27 23:59:11.689', false, '래드윔프스', 'RADWIMPS', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/rad_1724770751447.jpeg'),
        ('340cb74f-c770-43ce-91af-88cd2eff23d9', '2024-08-04 00:00:00.000', '2024-08-28 00:00:34.707', false, '요루시카', 'Yorushika', 'MIXED', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/yoru_1724770834339.jpg'),
        ('45c6e260-0ac1-4786-831f-7b077d8192e5', '2024-08-04 00:00:00.000', '2024-08-28 00:01:02.295', false, '미세스 그린 애플', 'Mrs. Green Apple', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/mrs_1724770862070.webp'),
        ('d187b6a2-4923-4611-bfff-f9c4c986566e', '2024-08-04 00:00:00.000', '2024-08-28 00:01:25.987', false, '빌리 아일리시', 'Billie Eilish', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/bille_1724770885854.jpeg'),
        ('5a4db81d-16e8-4033-8198-09bc92f57ca4', '2024-08-04 00:00:00.000', '2024-08-28 00:01:53.941', false, '마이클 볼튼', 'Michael Bolton', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/bolton_1724770913666.jpg'),
        ('3a2d52b1-b39f-4389-b1ee-a0fc0c38bc62', '2024-08-04 00:00:00.000', '2024-08-28 00:02:20.783', false, '두아리파', 'Dua Lipa', 'WOMAN', 'SOLO', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/dua_1724770939506.jpg'),
        ('9431dc41-7ce6-4d81-b680-a322595fe43d', '2024-08-04 00:00:00.000', '2024-08-28 00:02:44.027', false, '레드 핫 칠리 페퍼스', 'Red Hot Chili Peppers', 'MAN', 'GROUP', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/re_1724770963768.webp'),
        ('0d38c2cd-0be8-49b5-a719-b17db10afe84', '2024-08-04 00:00:00.000', '2024-08-28 00:03:10.591', false, '아델', 'Adele', 'WOMAN', 'SOLO', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/adele_1724770990394.jpeg'),
        ('8996c8dc-b8a2-449b-9c19-09cd49e2924d', '2024-08-04 00:00:00.000', '2024-08-28 00:03:34.616', false, '에드 시런', 'Ed Sheeran', 'MAN', 'SOLO', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/ed_1724771014309.jpg'),
        ('2204c6fa-c78d-420f-b689-b8932aaf50a7', '2024-08-04 00:00:00.000', '2024-08-28 00:04:00.548', false, '레이디가가', 'Lady Gaga', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/lady_1724771040382.jpg'),
        ('82311401-6764-44bd-9fb4-a2bb37a89cfd', '2024-08-04 00:00:00.000', '2024-08-28 00:04:23.188', false, '데프 레퍼드', 'Def Leppard', 'MAN', 'GROUP', 'UK', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/def_1724771063040.webp'),
        ('7b3acbb2-6d90-4bc0-a510-95688ffbdbc7', '2024-08-04 00:00:00.000', '2024-08-28 00:04:45.129', false, '에이씨디씨', 'AC/DC', 'MAN', 'GROUP', 'Australia', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/acdc_1724771083568.webp'),
        ('aa4e4067-11cc-46f5-9548-5ebdc40b91a3', '2024-08-04 00:00:00.000', '2024-08-28 00:05:15.566', false, '요니지', 'Yonige', 'WOMAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Yonige_1724771115274.webp'),
        ('3d367630-37a4-41be-8d09-4434e4c24d09', '2024-08-04 00:00:00.000', '2024-08-28 00:06:04.944', false, '스티비 원더', 'Stevie Wonder', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/stevie_1724771164729.jpg'),
        ('967573c3-fcee-453a-b9ee-177359ff7dba', '2024-08-04 00:00:00.000', '2024-08-28 00:06:24.071', false, '호시노 겐', 'Gen Hoshino', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Gen%20Hoshino_1724771183773.jpg'),
        ('b71a2ee4-a110-4e6c-a49c-e135a8311b6b', '2024-08-04 00:00:00.000', '2024-08-28 00:07:08.746', false, '마일리 사이러스', 'Miley Cyrus', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Miley%20Cyrus_1724771228212.jpg'),
        ('525c7aec-3c72-45c9-9e53-f904869b1306', '2024-08-04 00:00:00.000', '2024-08-28 00:06:48.240', false, '크리피 넛츠', 'Creepy Nuts', 'MAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Creepy%20Nuts_1724771203464.jpeg'),
        ('1aab6fed-7d20-42ed-9f59-67713671f813', '2024-08-04 00:00:00.000', '2024-08-28 00:07:36.693', false, '베케이션스', 'Vacations', 'MAN', 'GROUP', 'Australia', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/vacations_1724771256358.jpeg'),
        ('129fb608-eeb9-42ec-87f6-e1515bdf2696', '2024-08-04 00:00:00.000', '2024-08-28 00:07:57.832', false, '사카낙션', 'Sakanaction', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Sakanaction_1724771277698.jpeg'),
        ('ec304557-e9f1-4bf3-8abf-62c83dec099f', '2024-08-04 00:00:00.000', '2024-08-27 23:19:40.011', false, '포스트 말론', 'Post Malone', 'MAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/%E1%84%91%E1%85%A9%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%E1%84%86%E1%85%A1%E1%86%AF%E1%84%85%E1%85%A9%E1%86%AB_1724768379768.webp'),
        ('977452b5-db8e-48b9-abe6-d06b44a1b4ad', '2024-08-04 00:00:00.000', '2024-08-27 23:24:53.214', false, '이브', 'Eve', 'WOMAN', 'SOLO', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/eve_1724768692720.jpg'),
        ('dac4fda7-1746-4eb3-8b87-cab78ae86c75', '2024-08-04 00:00:00.000', '2024-08-27 23:26:04.511', false, '엘르가든', 'Ellegarden', 'MAN', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/elle_1724768764249.jpg'),
        ('17790b8d-4e2c-4ec5-a524-d00d80a9868e', '2024-08-04 00:00:00.000', '2024-08-27 23:47:48.276', false, '라나 델 레이', 'Lana Del Rey', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/lana_1724770067708.webp'),
        ('87228380-e581-46d9-b524-869360451d02', '2024-08-04 00:00:00.000', '2024-08-28 00:05:35.377', false, '녹황색사회', 'Ryokuoushoku Shakai', 'MIXED', 'GROUP', 'Japan', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artist/Ryokuoushoku%20Shakai_1724771135189.jpg'),
        ('01919929-4987-34c0-0f5d-57dc5479f08a', '2024-08-28 22:25:05.576', '2024-08-28 22:25:05.576', false, '올리비아 로드리고', 'Olivia Rodrigo', 'WOMAN', 'SOLO', 'USA', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/artists/olivia_1724851504951.jpg');

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

-- Olivia Lodorigo
INSERT INTO public.artist_genre (id, created_at, updated_at, is_deleted, artist_id, genre_id)
VALUES (gen_random_uuid(), '2024-08-28 22:25:05.605', '2024-08-28 22:25:05.605', false,
        '01919929-4987-34c0-0f5d-57dc5479f08a', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1'),
        (gen_random_uuid(), '2024-08-28 22:25:05.608', '2024-08-28 22:25:05.608', false,
         '01919929-4987-34c0-0f5d-57dc5479f08a', '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5');

-- artist search
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b9f79017-f97d-44b1-82ce-645e92856c0b', '콜드플레이');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b9f79017-f97d-44b1-82ce-645e92856c0b', 'coldplay');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'ec304557-e9f1-4bf3-8abf-62c83dec099f', '포스트말론');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'ec304557-e9f1-4bf3-8abf-62c83dec099f',
        'postmalone');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '977452b5-db8e-48b9-abe6-d06b44a1b4ad', '이브');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '977452b5-db8e-48b9-abe6-d06b44a1b4ad', 'eve');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', '스파이에어');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', 'spyair');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'dac4fda7-1746-4eb3-8b87-cab78ae86c75', '엘르가든');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'dac4fda7-1746-4eb3-8b87-cab78ae86c75',
        'ellegarden');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '킹누');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6', 'kinggnu');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f56b52c1-72c2-450c-ad59-e88db1530dcb', '브루노마스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f56b52c1-72c2-450c-ad59-e88db1530dcb',
        'brunomars');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'a94dc17e-4b77-4959-bb1d-a3bd9735cf01', '찰리푸스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'a94dc17e-4b77-4959-bb1d-a3bd9735cf01',
        'charlieputh');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '0b60cd2a-5312-41a2-ba1d-db1acb72460b', '테일러스위프트');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '0b60cd2a-5312-41a2-ba1d-db1acb72460b',
        'taylorswift');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '02c9aedf-9ea2-4720-83c5-eeacd79a2e6e', '위켄드');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '02c9aedf-9ea2-4720-83c5-eeacd79a2e6e',
        'theweeknd');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c3df1fe2-0795-4204-92d6-68d3d6f4bc05', '저스틴비버');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c3df1fe2-0795-4204-92d6-68d3d6f4bc05',
        'justinbieber');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '7a97697e-2fa0-4d5b-851f-dd8864b5b49a', '올리비아딘');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '7a97697e-2fa0-4d5b-851f-dd8864b5b49a',
        'oliviadean');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'fdf9929d-9001-489a-9d7f-a345581ca6bd', '새미비르지');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'fdf9929d-9001-489a-9d7f-a345581ca6bd',
        'sammyvirji');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '1535086f-99ff-493e-bfb4-254f15d87e5d', '디스클로저');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '1535086f-99ff-493e-bfb4-254f15d87e5d',
        'disclosure');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f5d0d77a-e5f2-42ff-8478-5a70b3d7ba50', '라디오헤드');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f5d0d77a-e5f2-42ff-8478-5a70b3d7ba50',
        'radiohead');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e7bf557b-8591-418f-8422-d1f08c26df2f', '에이제이알');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e7bf557b-8591-418f-8422-d1f08c26df2f', 'ajr');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e7f28490-8e4c-426b-92fc-fbcb226ea7f7', '크리스토퍼');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e7f28490-8e4c-426b-92fc-fbcb226ea7f7',
        'christopher');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b50a931a-d4f3-4c32-8636-253e4fff45ab', '스트록스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b50a931a-d4f3-4c32-8636-253e4fff45ab',
        'thestrokes');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '72cdcdb7-1fed-460d-a316-3988ffa1a6c8', '벤슨분');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '72cdcdb7-1fed-460d-a316-3988ffa1a6c8',
        'bensonboone');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e86ca40e-29f3-48d3-921f-c51d5e8c05e0', '아리아나그란데');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e86ca40e-29f3-48d3-921f-c51d5e8c05e0',
        'arianagrande');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '6d7fee98-4719-4afc-9113-42177e417cb8', '코난그레이');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '6d7fee98-4719-4afc-9113-42177e417cb8',
        'conangray');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'ac400fd9-d188-4dfa-81a9-80d092317855', '마룬5');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'ac400fd9-d188-4dfa-81a9-80d092317855', 'maroon5');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '8c85815e-cd89-44cf-912d-d8c92a0ace60', '이메진드래곤스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '8c85815e-cd89-44cf-912d-d8c92a0ace60',
        'imaginedragons');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '1d6bd071-dd58-4411-988b-4a6146f59c80', '요아소비');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '1d6bd071-dd58-4411-988b-4a6146f59c80', 'yoasobi');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f5fc86ee-0519-409c-9bed-ae0dbead3bea', '라우브');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f5fc86ee-0519-409c-9bed-ae0dbead3bea', 'lauv');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'db8e5dbb-fc91-48d6-ba0f-0100004a64af', '레이니');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'db8e5dbb-fc91-48d6-ba0f-0100004a64af', 'lany');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'de7b5c97-16d4-4d0b-bf52-b58f28b5475c', '혼네');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'de7b5c97-16d4-4d0b-bf52-b58f28b5475c', 'honne');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '059f8de8-e3f7-4e3b-a1da-89a8c4b73f70',
        '노엘갤러거하이플라잉버즈');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '059f8de8-e3f7-4e3b-a1da-89a8c4b73f70',
        'noelgallagher`shighflyingbirds');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2c8afe0e-1c1b-4226-b20e-726faa1fc48c', '그린데이');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2c8afe0e-1c1b-4226-b20e-726faa1fc48c', 'greenday');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b4e388ca-5a54-4e2e-8624-ddd363b32a75', '모네스킨');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b4e388ca-5a54-4e2e-8624-ddd363b32a75', 'måneskin');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e22c3c45-b88b-4278-b20d-270aac64229e', '유우리');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e22c3c45-b88b-4278-b20d-270aac64229e', 'yuuri');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b6f220ab-34ad-40ee-b797-ec5c24459aa9', '트래비스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b6f220ab-34ad-40ee-b797-ec5c24459aa9', 'travis');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'eb93b4ca-be7c-409f-b48d-5301ee0b02fe', '머라이어캐리');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'eb93b4ca-be7c-409f-b48d-5301ee0b02fe',
        'mariahcarey');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '43e17c11-c3b7-4dd9-a92e-fdadb8783bca',
        '계속한밤중이면좋을텐데');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '43e17c11-c3b7-4dd9-a92e-fdadb8783bca', 'zutomayo');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'fdc16095-1bb1-4cc6-8e2f-75495a6f3a13', '원오크락');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'fdc16095-1bb1-4cc6-8e2f-75495a6f3a13',
        'oneokrock');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2f8c8f6c-842a-48cd-9ed7-f84710d3fef2', '뉴호프클럽');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2f8c8f6c-842a-48cd-9ed7-f84710d3fef2',
        'newhopeclub');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '6b1aeec8-ac19-4a6a-92b5-5e71733ef204', '마이클부불레');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '6b1aeec8-ac19-4a6a-92b5-5e71733ef204',
        'michaelbublé');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2e277ef0-c3f1-4f80-9ed0-4db0a3350e12', '저스틴팀버레이크');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2e277ef0-c3f1-4f80-9ed0-4db0a3350e12',
        'justintimberlake');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e0fc0ab6-19ee-47ef-a50d-45ab7efe3bba', '와니마');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e0fc0ab6-19ee-47ef-a50d-45ab7efe3bba', 'wanima');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '772efb86-0af8-4dc6-b73b-bd226fb86944', '후지이카제');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '772efb86-0af8-4dc6-b73b-bd226fb86944',
        'fujiikaze');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '268ad7b1-7550-4cab-bb04-273b1649e682', '레오루');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '268ad7b1-7550-4cab-bb04-273b1649e682', 'reol');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e3753ac5-a079-417a-b75a-7593d9b802ad', '정글');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e3753ac5-a079-417a-b75a-7593d9b802ad', 'jungle');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '5aeb15be-b150-4915-a242-d35cdee8aeb4', '나씽벗띠브스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '5aeb15be-b150-4915-a242-d35cdee8aeb4',
        'nothingbutthieves');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '01681324-678a-4e9a-a80b-e93d038bf75f', '제이콥콜리어');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '01681324-678a-4e9a-a80b-e93d038bf75f',
        'jacobcollier');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '17790b8d-4e2c-4ec5-a524-d00d80a9868e', '라나델레이');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '17790b8d-4e2c-4ec5-a524-d00d80a9868e',
        'lanadelrey');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '88ade2ad-96ac-4ed4-8dce-72aec8d8545d',
        '원오트릭스포인트네버');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '88ade2ad-96ac-4ed4-8dce-72aec8d8545d',
        'opn(oneohtrixpointnever)');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c440d4e0-3f52-4225-9bc2-f1183a4b9f22',
        '코코앤클레어클레어');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c440d4e0-3f52-4225-9bc2-f1183a4b9f22',
        'coco&clairclair');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '036854c0-9d22-4660-89f9-0abd16dd3ec1', '쿠키카와이');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '036854c0-9d22-4660-89f9-0abd16dd3ec1',
        'cookieekawaii');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e139192f-ba01-4a15-b0b1-86005aee3c1d', '킹크룰');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e139192f-ba01-4a15-b0b1-86005aee3c1d',
        'kingkrule');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'd63490e9-0eaf-4914-be90-8d34381b5b05', '켄드릭라마');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'd63490e9-0eaf-4914-be90-8d34381b5b05',
        'kendricklamar');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '56a4a4af-dc3f-4f9f-9316-6bcd20d99455', '오피셜히게단디즘');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '56a4a4af-dc3f-4f9f-9316-6bcd20d99455',
        'officialhigedandism');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '687f2125-f72e-45c9-84cc-3181fa5af912', '바운디');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '687f2125-f72e-45c9-84cc-3181fa5af912', 'vaundy');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '909593a3-d067-4dae-9b4a-e14c8accb1aa', '나토리');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '909593a3-d067-4dae-9b4a-e14c8accb1aa', 'natori');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '10c0c327-8053-4792-ae0b-413d337ec413', '아도');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '10c0c327-8053-4792-ae0b-413d337ec413', 'ado');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e19d1403-c4b3-4a6f-b5b8-8e935cb645c4', '와누카');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'e19d1403-c4b3-4a6f-b5b8-8e935cb645c4', 'wanuka');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '80154f71-f7b6-4d06-be39-2e4e00b281a1', '요네즈켄시');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '80154f71-f7b6-4d06-be39-2e4e00b281a1',
        'kenshiyonezu');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '4fd6cc98-3e3a-42bf-b04d-1563335397ad', '이마세');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '4fd6cc98-3e3a-42bf-b04d-1563335397ad', 'imase');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c89e680f-1f9a-41a0-bc35-b835e67dcace', '리사');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c89e680f-1f9a-41a0-bc35-b835e67dcace', 'lisa');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2f3532d6-f6f6-4b34-950f-7e4fc701e009', '아이묭');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2f3532d6-f6f6-4b34-950f-7e4fc701e009', 'aimyon');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f636f96a-7a42-416b-bab8-1cb8e1d2c314', '에메');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'f636f96a-7a42-416b-bab8-1cb8e1d2c314', 'aimer');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c62a2a56-1723-44f2-abb2-7a344db06afe', '츠키');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'c62a2a56-1723-44f2-abb2-7a344db06afe', 'tuki.');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '6342db02-e3ee-494b-91f0-15ba144b906c', '히즈치분가쿠');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '6342db02-e3ee-494b-91f0-15ba144b906c',
        'hitsujibungaku');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'ec82d1dd-7eb7-4801-bd44-86d6096e4dea', '밀레니엄퍼레이드');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'ec82d1dd-7eb7-4801-bd44-86d6096e4dea',
        'millenniumparade');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '5adeac70-0723-4869-831c-aace7691412c', '야마');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '5adeac70-0723-4869-831c-aace7691412c', 'yama');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '0dcf43ed-2a0c-4a54-af53-40eaa5c33776', '래드윔프스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '0dcf43ed-2a0c-4a54-af53-40eaa5c33776', 'radwimps');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '340cb74f-c770-43ce-91af-88cd2eff23d9', '요루시카');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '340cb74f-c770-43ce-91af-88cd2eff23d9',
        'yorushika');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '45c6e260-0ac1-4786-831f-7b077d8192e5', '미세스그린애플');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '45c6e260-0ac1-4786-831f-7b077d8192e5',
        'mrs.greenapple');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'd187b6a2-4923-4611-bfff-f9c4c986566e', '빌리아일리시');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'd187b6a2-4923-4611-bfff-f9c4c986566e',
        'billieeilish');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '5a4db81d-16e8-4033-8198-09bc92f57ca4', '마이클볼튼');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '5a4db81d-16e8-4033-8198-09bc92f57ca4',
        'michaelbolton');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '3a2d52b1-b39f-4389-b1ee-a0fc0c38bc62', '두아리파');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '3a2d52b1-b39f-4389-b1ee-a0fc0c38bc62', 'dualipa');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '9431dc41-7ce6-4d81-b680-a322595fe43d', '레드핫칠리페퍼스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '9431dc41-7ce6-4d81-b680-a322595fe43d',
        'redhotchilipeppers');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '0d38c2cd-0be8-49b5-a719-b17db10afe84', '아델');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '0d38c2cd-0be8-49b5-a719-b17db10afe84', 'adele');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '9ab800fa-158c-4577-b4a0-15f7df9d641a', '이매진드래곤스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '9ab800fa-158c-4577-b4a0-15f7df9d641a',
        'imaginedragons');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '8996c8dc-b8a2-449b-9c19-09cd49e2924d', '에드시런');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '8996c8dc-b8a2-449b-9c19-09cd49e2924d',
        'edsheeran');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2204c6fa-c78d-420f-b689-b8932aaf50a7', '레이디가가');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '2204c6fa-c78d-420f-b689-b8932aaf50a7', 'ladygaga');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '82311401-6764-44bd-9fb4-a2bb37a89cfd', '데프레퍼드');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '82311401-6764-44bd-9fb4-a2bb37a89cfd',
        'defleppard');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '7b3acbb2-6d90-4bc0-a510-95688ffbdbc7', '에이씨디씨');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '7b3acbb2-6d90-4bc0-a510-95688ffbdbc7', 'ac/dc');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'aa4e4067-11cc-46f5-9548-5ebdc40b91a3', '요니지');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'aa4e4067-11cc-46f5-9548-5ebdc40b91a3', 'yonige');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '87228380-e581-46d9-b524-869360451d02', '녹황색사회');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '87228380-e581-46d9-b524-869360451d02',
        'ryokuoushokushakai');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '3d367630-37a4-41be-8d09-4434e4c24d09', '스티비원더');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '3d367630-37a4-41be-8d09-4434e4c24d09',
        'steviewonder');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '967573c3-fcee-453a-b9ee-177359ff7dba', '호시노겐');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '967573c3-fcee-453a-b9ee-177359ff7dba',
        'genhoshino');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '525c7aec-3c72-45c9-9e53-f904869b1306', '크리피넛츠');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '525c7aec-3c72-45c9-9e53-f904869b1306',
        'creepynuts');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b71a2ee4-a110-4e6c-a49c-e135a8311b6b', '마일리사이러스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, 'b71a2ee4-a110-4e6c-a49c-e135a8311b6b',
        'mileycyrus');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '1aab6fed-7d20-42ed-9f59-67713671f813', '베케이션스');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '1aab6fed-7d20-42ed-9f59-67713671f813',
        'vacations');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '129fb608-eeb9-42ec-87f6-e1515bdf2696', '사카낙션');
INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), now(), now(), false, '129fb608-eeb9-42ec-87f6-e1515bdf2696',
        'sakanaction');

INSERT INTO artist_search(id, created_at, updated_at, is_deleted, artist_id, name)
VALUES (gen_random_uuid(), '2024-08-28 22:25:05.601', '2024-08-28 22:25:05.601', false, '01919929-4987-34c0-0f5d-57dc5479f08a', '올리비아로드리고'),
        (gen_random_uuid(), '2024-08-28 22:25:05.603', '2024-08-28 22:25:05.603', false, '01919929-4987-34c0-0f5d-57dc5479f08a', 'oliviarodrigo');

-- SHOW
insert into public.show (id, created_at, updated_at, is_deleted, start_date, end_date, title, content, location, image, last_ticketing_at, view_count, seat_prices, ticketing_sites)
values  ('019194ba-562b-a6bc-b7e9-42d21e566111', '2024-08-28 01:45:25.429', '2024-08-29 12:53:21.299', false, '2024-11-02', '2024-11-03', '벤슨 분 내한공연', '.', '잠실 실내체육관', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/bessen_1724936000331.jpg', '2024-09-30 21:51:00.000', 0, '{"스탠딩석": 110000, "스탠딩 P석": 99000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b5-d4a3-5186-2ae2-008109252b27', '2024-08-28 01:40:30.116', '2024-08-29 13:11:13.162', false, '2024-10-05', '2024-10-06', '디스클로저 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/disclosure_1724937072972.jpg', '2024-09-05 22:10:00.000', 0, '{"스탠딩석": 120000, "스탠딩 P석": 100000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b8-79f5-e976-7be4-1a07018ad0ee', '2024-08-28 01:43:23.511', '2024-08-29 13:03:20.656', false, '2024-12-12', '2024-12-13', '크리스토퍼 내한공연', '.', '링크아트센터드림 드림4관', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/christopher_1724936600566.jpg', '2024-09-07 22:02:00.000', 0, '{"스탠딩석": 130000, "스탠딩 P석": 110000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('01919901-105d-b5b2-cbaf-912f20281ce8', '2024-08-28 12:41:09.485', '2024-08-28 16:02:19.184', false, '2024-12-01', '2024-12-01', '2024 오피셜히게단디즘 내한공연', '.', '일산 킨텍스 제1전시장 5홀', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-28%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%209.37.40_1724848869198.png', '2024-08-28 21:40:00.000', 1, '{"스탠딩 R석": 132000, "스탠딩 S석": 121000}', '{"YES24": "http://ticket.yes24.com/", "인퍼타크": "https://tickets.interpark.com/goods/24011642", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('0191948f-0ba0-2a3b-9b19-bd42694ecf58', '2024-08-28 00:58:08.315', '2024-08-29 11:28:18.871', false, '2024-09-06', '2024-09-07', '코난 그레이 내한공연', '.', '명화 라이브홀', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-28%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%209.50.56_1724849732460.png', '2024-05-08 00:00:00.000', 2, '{"스탠딩석": 110000, "지정석 P석": 121000, "지정석 R석": 99000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/goods/24006288", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194a9-c1b5-407a-fae8-324bc240db6d', '2024-08-28 01:27:18.840', '2024-08-29 12:55:22.078', false, '2025-01-17', '2025-01-17', '콜드플레이 내한공연', '.', '여의도 KBS홀', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C_1724936121968.jfif', '2024-11-13 14:00:00.000', 2, '{"R석": 88000, "S석": 77000, "VIP석": 99000, "2층석": 55000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/goods/19018885?tab=2", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b9-a3c3-5cd7-b35d-2c133907812d', '2024-08-28 01:44:39.747', '2024-08-29 12:59:48.806', false, '2024-11-05', '2024-11-06', '스트록스 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/stroke_1724936388679.webp', '2024-12-22 21:59:00.000', 0, '{"스탠딩석": 120000, "스탠딩 P석": 100000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/"}'),
        ('019194aa-d2fd-e29f-96c7-df9101dfd1b6', '2024-08-28 01:28:28.799', '2024-08-29 13:03:53.384', false, '2024-09-27', '2024-09-27', '포스트말론 내한공연', '.', '여의도 KBS홀', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C%20%281%29_1724936633293.jfif', '2024-09-01 14:00:00.000', 0, '{"스탠딩P석": 165000, "스탠딩R석": 143000, "스탠딩S석": 121000, "지정석P석": 176000, "지정석R석": 154000}', '{"YES24": "https://tickets.interpark.com/goods/19018885?tab=2", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b7-b2a8-33d0-6f93-dcdcfbd7fdea', '2024-08-28 01:42:32.490', '2024-08-29 13:06:41.236', false, '2024-11-02', '2024-11-03', 'AJR 내한공연', '.', '무신사 개러지', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/ajr_1724936801101.png', '2024-10-03 22:05:00.000', 0, '{"스탠딩석": 140000, "스탠딩 P석": 120000, "스탠딩 R석": 100000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b6-bf4a-3f6d-91d5-4de8ab1bf027', '2024-08-28 01:41:30.188', '2024-08-29 13:09:41.866', false, '2024-11-20', '2024-11-21', '라디오헤드 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/radio_1724936981764.jpg', '2024-10-05 22:09:00.000', 0, '{"스탠딩석": 135000, "스탠딩 P석": 120000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194ac-757e-265a-a639-0f20626ad748', '2024-08-28 01:30:15.935', '2024-08-29 13:09:55.349', false, '2024-10-05', '2024-10-06', '이브 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/20240807-50595_1724936995269.jpg', '2024-09-06 14:00:00.000', 1, '{"지정석": 121000, "스탠딩석": 121000}', '{"YES24": "http://ticket.yes24.com/Perf/50595", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194ad-1663-4319-c525-12ece13f18ad', '2024-08-28 01:30:57.127', '2024-08-29 13:13:00.978', false, '2024-11-23', '2024-11-24', '스파이에어 내한공연', '.', '무신사 개러지', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/24001773_p_1724937180835.gif', '2024-09-20 14:00:00.000', 0, '{"스탠딩석": 90000}', '{"YES24": "https://tickets.interpark.com/goods/24001773", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b4-e020-8a98-ae34-fc1a6f633c18', '2024-08-28 01:39:27.521', '2024-08-29 13:14:58.486', false, '2024-11-02', '2024-11-03', '라우브 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/lauv_1724937298375.jpg', '2024-09-21 22:14:00.000', 0, '{"스탠딩석": 120000, "스탠딩 P석": 110000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b4-1d54-17c7-196b-8736d867649e', '2024-08-28 01:38:37.653', '2024-08-29 13:16:49.099', false, '2024-11-02', '2024-11-03', '올리비아 딘 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/olivia_1724937409012.webp', '2024-09-18 22:16:00.000', 0, '{"스탠딩석": 130000, "스탠딩 P석": 110000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194ad-db9c-09fc-e0a6-ed4ec8888fb8', '2024-08-28 01:31:47.613', '2024-08-29 13:17:32.658', false, '2024-10-03', '2024-10-04', '엘르가든 내한공연', '.', 'YES24 라이브홀', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C%20%282%29_1724937452498.jfif', '2024-09-13 14:00:00.000', 0, '{"스탠딩석": 90000}', '{"YES24": "http://ticket.yes24.com/Perf/46905", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b3-7974-5f00-d9cf-7a8632b8e0e9', '2024-08-28 01:37:55.705', '2024-08-29 13:18:33.437', false, '2024-12-16', '2024-12-17', '저스틴 비버 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/justin_1724937513359.jpg', '2024-09-28 22:18:00.000', 0, '{"스탠딩석": 140000, "스탠딩 P석": 120000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194ae-9b20-8972-0c7c-81704c1dfc1a', '2024-08-28 01:32:36.641', '2024-08-29 13:20:38.684', false, '2024-10-19', '2024-10-20', '킹누 내한공연', '.', '올림픽공원 올림픽홀', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/20240321-48195_1724937638600.jpg', '2024-09-12 12:00:00.000', 0, '{"A석": 80000, "R석": 120000, "S석": 110000}', '{"YES24": "http://ticket.yes24.com/Perf/48195", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b2-748c-b8e2-e00b-59d3c98d02c1', '2024-08-28 01:36:48.910', '2024-08-29 13:20:49.866', false, '2024-11-19', '2024-11-20', '위켄드 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/weekend_1724937649797.jpg', '2024-09-05 22:19:00.000', 0, '{"스탠딩석": 120000, "스탠딩 P석": 111000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194af-d678-94df-5fe1-83c3b0d85941', '2024-08-28 01:33:57.370', '2024-08-29 13:24:02.704', false, '2024-11-16', '2024-11-17', '브루노마스 공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/23005708_p_1724937842603.gif', '2024-09-24 12:00:00.000', 0, '{"A석": 77000, "P석": 176000, "R석": 132000, "S석": 99000, "G1석": 250000, "G2석": 210000, "G3석": 165000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/goods/23005708?tab=2", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b0-cd60-a404-4151-ec9602666ea9', '2024-08-28 01:35:00.577', '2024-08-29 13:24:08.356', false, '2024-11-16', '2024-11-17', '찰리 푸스 내한공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/chalie_1724937848287.jpg', '2024-09-09 22:23:00.000', 0, '{"스탠딩석": 143000, "스탠딩 P석": 125000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194a4-e4ba-f2d1-79d6-23088c9c3112', '2024-08-28 01:22:00.130', '2024-08-28 16:02:01.733', false, '2024-12-04', '2024-12-05', '두아리파 내한공연', '.', '고척 스카이돔', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-28%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.01.45_1724850287739.png', '2024-06-20 00:00:00.000', 1, '{"스탠딩 P석": 154000, "스탠딩 R석": 143000, "지정석 A석": 132000, "지정석 B석": 121000, "지정석 P석": 176000, "지정석 R석": 165000, "지정석 S석": 143000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/goods/24007623", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('01919906-7fb9-6552-3819-91a5295bb3e6', '2024-08-28 12:47:05.658', '2024-08-29 12:08:26.850', false, '2024-09-20', '2024-09-21', '올리비아 로드리고 첫 내한공연', '.', '잠실 실내체육관', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-28%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%209.44.08_1724849225398.png', '2024-05-17 00:00:00.000', 3, '{"스탠딩 P석": 154000, "지정석 A석": 99000, "지정석 P석": 165000, "지정석 R석": 132000, "지정석 S석": 121000, "스탠딩 PIT 패키지": 262000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/goods/24006714", "멜론티켓": "https://ticket.melon.com/main/index.htm"}'),
        ('019194b1-a2b0-6a29-9d33-d1a4c8fad5cf', '2024-08-28 01:35:55.185', '2024-08-29 13:22:34.020', false, '2024-12-21', '2024-12-22', '테일러 스위프트 공연', '.', '서울 잠실', 'https://showpot-s3.s3.ap-northeast-2.amazonaws.com/show/tailer_1724937753926.jpg', '2024-09-21 22:21:00.000', 0, '{"스탠딩석": 130000, "스탠딩 P석": 140000}', '{"YES24": "http://ticket.yes24.com/", "인터파크": "https://tickets.interpark.com/", "멜론티켓": "https://ticket.melon.com/main/index.htm"}');

-- Show Artist
insert into public.show_artist (id, created_at, updated_at, is_deleted, artist_id, show_id)
values  ('0191948f-0bde-cedc-3946-63dc1a821b7f', '2024-08-28 00:58:08.352', '2024-08-28 00:58:08.352', false, '6d7fee98-4719-4afc-9113-42177e417cb8', '0191948f-0ba0-2a3b-9b19-bd42694ecf58'),
        ('019194a4-e4c9-ee22-ab43-376174cba357', '2024-08-28 01:22:00.138', '2024-08-28 01:22:00.138', false, '3a2d52b1-b39f-4389-b1ee-a0fc0c38bc62', '019194a4-e4ba-f2d1-79d6-23088c9c3112'),
        ('019194a9-c1c3-4065-017b-988b20cef8d8', '2024-08-28 01:27:18.852', '2024-08-28 01:27:18.852', false, 'b9f79017-f97d-44b1-82ce-645e92856c0b', '019194a9-c1b5-407a-fae8-324bc240db6d'),
        ('019194aa-d308-df64-250a-4cb4083fee85', '2024-08-28 01:28:28.809', '2024-08-28 01:28:28.809', false, 'ec304557-e9f1-4bf3-8abf-62c83dec099f', '019194aa-d2fd-e29f-96c7-df9101dfd1b6'),
        ('019194ac-758b-1f3c-972d-7304fda5f8f3', '2024-08-28 01:30:15.949', '2024-08-28 01:30:15.949', false, '977452b5-db8e-48b9-abe6-d06b44a1b4ad', '019194ac-757e-265a-a639-0f20626ad748'),
        ('019194ad-dba4-23fc-7cac-b51b98c2d6e0', '2024-08-28 01:31:47.620', '2024-08-28 01:31:47.620', false, 'dac4fda7-1746-4eb3-8b87-cab78ae86c75', '019194ad-db9c-09fc-e0a6-ed4ec8888fb8'),
        ('019194ae-9b2b-14cb-f6fe-159991752024', '2024-08-28 01:32:36.652', '2024-08-28 01:32:36.652', false, 'd3fc15e6-172f-4448-928b-7fdd7a6a9ab6', '019194ae-9b20-8972-0c7c-81704c1dfc1a'),
        ('019194af-d67c-fe62-0ea8-305c36e58032', '2024-08-28 01:33:57.372', '2024-08-28 01:33:57.372', false, 'f56b52c1-72c2-450c-ad59-e88db1530dcb', '019194af-d678-94df-5fe1-83c3b0d85941'),
        ('019194b0-cd69-6bcb-4952-2fdb8ce612f4', '2024-08-28 01:35:00.586', '2024-08-28 01:35:00.586', false, 'a94dc17e-4b77-4959-bb1d-a3bd9735cf01', '019194b0-cd60-a404-4151-ec9602666ea9'),
        ('019194b1-a2b7-832f-3b43-9f4f36310962', '2024-08-28 01:35:55.192', '2024-08-28 01:35:55.192', false, '0b60cd2a-5312-41a2-ba1d-db1acb72460b', '019194b1-a2b0-6a29-9d33-d1a4c8fad5cf'),
        ('019194b2-7492-db73-e0b3-3d86f18159d3', '2024-08-28 01:36:48.915', '2024-08-28 01:36:48.915', false, '02c9aedf-9ea2-4720-83c5-eeacd79a2e6e', '019194b2-748c-b8e2-e00b-59d3c98d02c1'),
        ('019194b3-797f-ef01-c343-aab7cb182e33', '2024-08-28 01:37:55.712', '2024-08-28 01:37:55.712', false, 'c3df1fe2-0795-4204-92d6-68d3d6f4bc05', '019194b3-7974-5f00-d9cf-7a8632b8e0e9'),
        ('019194b4-1d57-4d59-268e-629918c78e1c', '2024-08-28 01:38:37.655', '2024-08-28 01:38:37.655', false, '7a97697e-2fa0-4d5b-851f-dd8864b5b49a', '019194b4-1d54-17c7-196b-8736d867649e'),
        ('019194b5-d4a4-9322-7d90-834fabb0a7d1', '2024-08-28 01:40:30.117', '2024-08-28 01:40:30.117', false, '1535086f-99ff-493e-bfb4-254f15d87e5d', '019194b5-d4a3-5186-2ae2-008109252b27'),
        ('019194b6-bf51-6488-37c0-30d7246cc16e', '2024-08-28 01:41:30.193', '2024-08-28 01:41:30.193', false, 'f5d0d77a-e5f2-42ff-8478-5a70b3d7ba50', '019194b6-bf4a-3f6d-91d5-4de8ab1bf027'),
        ('019194b7-b2ae-f88d-90f1-91d8c70f88e7', '2024-08-28 01:42:32.494', '2024-08-28 01:42:32.494', false, 'e7bf557b-8591-418f-8422-d1f08c26df2f', '019194b7-b2a8-33d0-6f93-dcdcfbd7fdea'),
        ('019194b8-79fa-f5df-11ba-d61dba7ac608', '2024-08-28 01:43:23.515', '2024-08-28 01:43:23.515', false, 'e7f28490-8e4c-426b-92fc-fbcb226ea7f7', '019194b8-79f5-e976-7be4-1a07018ad0ee'),
        ('019194b9-a3ca-5eee-9681-390d201e1311', '2024-08-28 01:44:39.755', '2024-08-28 01:44:39.755', false, 'b50a931a-d4f3-4c32-8636-253e4fff45ab', '019194b9-a3c3-5cd7-b35d-2c133907812d'),
        ('019194ba-5637-56d6-12da-083ed4334888', '2024-08-28 01:45:25.433', '2024-08-28 01:45:25.433', false, '72cdcdb7-1fed-460d-a316-3988ffa1a6c8', '019194ba-562b-a6bc-b7e9-42d21e566111'),
        ('01919901-1098-08dd-28a7-d1262d860c5f', '2024-08-28 12:41:09.530', '2024-08-28 12:41:09.530', false, '56a4a4af-dc3f-4f9f-9316-6bcd20d99455', '01919901-105d-b5b2-cbaf-912f20281ce8'),
        ('01919906-7fbb-681d-a67e-0180ad10e0e4', '2024-08-28 12:47:05.660', '2024-08-28 12:47:05.660', false, '01919929-4987-34c0-0f5d-57dc5479f08a', '01919906-7fb9-6552-3819-91a5295bb3e6'),
        ('01919e44-973b-5851-2dd0-c0d6dc68e814', '2024-08-29 13:13:00.993', '2024-08-29 13:13:00.993', false, '2ab7eba4-98f9-4936-ac1b-716bc2f04a1c', '019194ad-1663-4319-c525-12ece13f18ad'),
        ('01919e46-6248-1c68-290e-e58f26597f6f', '2024-08-29 13:14:58.504', '2024-08-29 13:14:58.504', false, 'f5fc86ee-0519-409c-9bed-ae0dbead3bea', '019194b4-e020-8a98-ae34-fc1a6f633c18');

-- Show Genre
insert into public.show_genre (id, created_at, updated_at, is_deleted, genre_id, show_id)
values  ('0191948f-0be2-dcb8-0356-46fa747d0316', '2024-08-28 00:58:08.355', '2024-08-28 00:58:08.355', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '0191948f-0ba0-2a3b-9b19-bd42694ecf58'),
        ('019194a4-e4ca-1ce4-e484-47e7d9514a2c', '2024-08-28 01:22:00.139', '2024-08-28 01:22:00.139', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194a4-e4ba-f2d1-79d6-23088c9c3112'),
        ('019194a9-c1c4-c763-a4d4-add1961f8ba0', '2024-08-28 01:27:18.853', '2024-08-28 01:27:18.853', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194a9-c1b5-407a-fae8-324bc240db6d'),
        ('019194a9-c1c4-c763-a4d4-add1961f8ba1', '2024-08-28 01:27:18.854', '2024-08-28 01:27:18.854', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '019194a9-c1b5-407a-fae8-324bc240db6d'),
        ('019194a9-c1c4-c763-a4d4-add1961f8ba2', '2024-08-28 01:27:18.856', '2024-08-28 01:27:18.856', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194a9-c1b5-407a-fae8-324bc240db6d'),
        ('019194aa-d309-61e7-60a0-c8320633d378', '2024-08-28 01:28:28.810', '2024-08-28 01:28:28.810', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194aa-d2fd-e29f-96c7-df9101dfd1b6'),
        ('019194aa-d309-61e7-60a0-c8320633d379', '2024-08-28 01:28:28.811', '2024-08-28 01:28:28.811', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2', '019194aa-d2fd-e29f-96c7-df9101dfd1b6'),
        ('019194aa-d309-61e7-60a0-c8320633d37a', '2024-08-28 01:28:28.811', '2024-08-28 01:28:28.811', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194aa-d2fd-e29f-96c7-df9101dfd1b6'),
        ('019194aa-d309-61e7-60a0-c8320633d37b', '2024-08-28 01:28:28.821', '2024-08-28 01:28:28.821', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194aa-d2fd-e29f-96c7-df9101dfd1b6'),
        ('019194ac-758d-1b94-01e1-095b53c93bb4', '2024-08-28 01:30:15.950', '2024-08-28 01:30:15.950', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d2', '019194ac-757e-265a-a639-0f20626ad748'),
        ('019194ac-758d-1b94-01e1-095b53c93bb5', '2024-08-28 01:30:15.951', '2024-08-28 01:30:15.951', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194ac-757e-265a-a639-0f20626ad748'),
        ('019194ad-dba5-9223-cc03-e6f63afbf6a1', '2024-08-28 01:31:47.621', '2024-08-28 01:31:47.621', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194ad-db9c-09fc-e0a6-ed4ec8888fb8'),
        ('019194ad-dba5-9223-cc03-e6f63afbf6a2', '2024-08-28 01:31:47.621', '2024-08-28 01:31:47.621', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '019194ad-db9c-09fc-e0a6-ed4ec8888fb8'),
        ('019194ad-dba5-9223-cc03-e6f63afbf6a3', '2024-08-28 01:31:47.621', '2024-08-28 01:31:47.621', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4', '019194ad-db9c-09fc-e0a6-ed4ec8888fb8'),
        ('019194ae-9b2c-f391-a2ad-0144af4aa23e', '2024-08-28 01:32:36.653', '2024-08-28 01:32:36.653', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194ae-9b20-8972-0c7c-81704c1dfc1a'),
        ('019194ae-9b2c-f391-a2ad-0144af4aa23f', '2024-08-28 01:32:36.653', '2024-08-28 01:32:36.653', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '019194ae-9b20-8972-0c7c-81704c1dfc1a'),
        ('019194ae-9b2c-f391-a2ad-0144af4aa240', '2024-08-28 01:32:36.653', '2024-08-28 01:32:36.653', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4', '019194ae-9b20-8972-0c7c-81704c1dfc1a'),
        ('019194ae-9b2c-f391-a2ad-0144af4aa241', '2024-08-28 01:32:36.653', '2024-08-28 01:32:36.653', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194ae-9b20-8972-0c7c-81704c1dfc1a'),
        ('019194af-d67c-fe62-0ea8-305c36e58033', '2024-08-28 01:33:57.373', '2024-08-28 01:33:57.373', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194af-d678-94df-5fe1-83c3b0d85941'),
        ('019194af-d67c-fe62-0ea8-305c36e58034', '2024-08-28 01:33:57.373', '2024-08-28 01:33:57.373', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194af-d678-94df-5fe1-83c3b0d85941'),
        ('019194af-d67c-fe62-0ea8-305c36e58035', '2024-08-28 01:33:57.373', '2024-08-28 01:33:57.373', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194af-d678-94df-5fe1-83c3b0d85941'),
        ('019194b0-cd69-6bcb-4952-2fdb8ce612f5', '2024-08-28 01:35:00.586', '2024-08-28 01:35:00.586', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194b0-cd60-a404-4151-ec9602666ea9'),
        ('019194b0-cd69-6bcb-4952-2fdb8ce612f6', '2024-08-28 01:35:00.586', '2024-08-28 01:35:00.586', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194b0-cd60-a404-4151-ec9602666ea9'),
        ('019194b1-a2b8-bc41-8aaf-cc0f2c020975', '2024-08-28 01:35:55.193', '2024-08-28 01:35:55.193', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194b1-a2b0-6a29-9d33-d1a4c8fad5cf'),
        ('019194b1-a2b8-bc41-8aaf-cc0f2c020976', '2024-08-28 01:35:55.193', '2024-08-28 01:35:55.193', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194b1-a2b0-6a29-9d33-d1a4c8fad5cf'),
        ('019194b2-7493-fdd5-8274-a4cff1111254', '2024-08-28 01:36:48.916', '2024-08-28 01:36:48.916', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194b2-748c-b8e2-e00b-59d3c98d02c1'),
        ('019194b3-7980-b19c-6d18-43b30889ecfa', '2024-08-28 01:37:55.716', '2024-08-28 01:37:55.716', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194b3-7974-5f00-d9cf-7a8632b8e0e9'),
        ('019194b3-7980-b19c-6d18-43b30889ecfb', '2024-08-28 01:37:55.717', '2024-08-28 01:37:55.717', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194b3-7974-5f00-d9cf-7a8632b8e0e9'),
        ('019194b4-1d57-4d59-268e-629918c78e1d', '2024-08-28 01:38:37.655', '2024-08-28 01:38:37.655', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194b4-1d54-17c7-196b-8736d867649e'),
        ('019194b4-e024-9aa8-3440-66c45a7c1dab', '2024-08-28 01:39:27.525', '2024-08-28 01:39:27.525', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194b4-e020-8a98-ae34-fc1a6f633c18'),
        ('019194b5-d4a5-bdcc-9549-806264838ebc', '2024-08-28 01:40:30.117', '2024-08-28 01:40:30.117', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d6', '019194b5-d4a3-5186-2ae2-008109252b27'),
        ('019194b6-bf51-6488-37c0-30d7246cc16f', '2024-08-28 01:41:30.194', '2024-08-28 01:41:30.194', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194b6-bf4a-3f6d-91d5-4de8ab1bf027'),
        ('019194b6-bf51-6488-37c0-30d7246cc170', '2024-08-28 01:41:30.194', '2024-08-28 01:41:30.194', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '019194b6-bf4a-3f6d-91d5-4de8ab1bf027'),
        ('019194b7-b2ae-f88d-90f1-91d8c70f88e8', '2024-08-28 01:42:32.495', '2024-08-28 01:42:32.495', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '019194b7-b2a8-33d0-6f93-dcdcfbd7fdea'),
        ('019194b7-b2ae-f88d-90f1-91d8c70f88e9', '2024-08-28 01:42:32.495', '2024-08-28 01:42:32.495', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194b7-b2a8-33d0-6f93-dcdcfbd7fdea'),
        ('019194b8-79fa-f5df-11ba-d61dba7ac609', '2024-08-28 01:43:23.515', '2024-08-28 01:43:23.515', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194b8-79f5-e976-7be4-1a07018ad0ee'),
        ('019194b9-a3cb-d100-2b33-66a0e3d277db', '2024-08-28 01:44:39.755', '2024-08-28 01:44:39.755', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194b9-a3c3-5cd7-b35d-2c133907812d'),
        ('019194b9-a3cb-d100-2b33-66a0e3d277dc', '2024-08-28 01:44:39.756', '2024-08-28 01:44:39.756', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '019194b9-a3c3-5cd7-b35d-2c133907812d'),
        ('019194ba-5638-dbea-365d-5803a04890d0', '2024-08-28 01:45:25.433', '2024-08-28 01:45:25.433', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '019194ba-562b-a6bc-b7e9-42d21e566111'),
        ('01919901-10a6-2c7c-4591-7b8fe17c8fb6', '2024-08-28 12:41:09.544', '2024-08-28 12:41:09.544', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '01919901-105d-b5b2-cbaf-912f20281ce8'),
        ('01919901-10a6-2c7c-4591-7b8fe17c8fb7', '2024-08-28 12:41:09.547', '2024-08-28 12:41:09.547', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '01919901-105d-b5b2-cbaf-912f20281ce8'),
        ('01919901-10a6-2c7c-4591-7b8fe17c8fb8', '2024-08-28 12:41:09.549', '2024-08-28 12:41:09.549', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4', '01919901-105d-b5b2-cbaf-912f20281ce8'),
        ('01919906-7fbc-f2f0-2a5c-92bef16c2425', '2024-08-28 12:47:05.661', '2024-08-28 12:47:05.661', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '01919906-7fb9-6552-3819-91a5295bb3e6'),
        ('01919906-7fbc-f2f0-2a5c-92bef16c2426', '2024-08-28 12:47:05.661', '2024-08-28 12:47:05.661', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d5', '01919906-7fb9-6552-3819-91a5295bb3e6'),
        ('01919e44-9746-ad52-d2e1-acd7952dc83f', '2024-08-29 13:13:01.002', '2024-08-29 13:13:01.002', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d1', '019194ad-1663-4319-c525-12ece13f18ad'),
        ('01919e44-9746-ad52-d2e1-acd7952dc840', '2024-08-29 13:13:01.002', '2024-08-29 13:13:01.002', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d3', '019194ad-1663-4319-c525-12ece13f18ad'),
        ('01919e44-9746-ad52-d2e1-acd7952dc841', '2024-08-29 13:13:01.002', '2024-08-29 13:13:01.002', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d4', '019194ad-1663-4319-c525-12ece13f18ad'),
        ('01919e46-624b-ef48-42b9-fd4596f5d7ed', '2024-08-29 13:14:58.508', '2024-08-29 13:14:58.508', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194b4-e020-8a98-ae34-fc1a6f633c18'),
        ('01919e48-bc7e-c832-99f1-c965b1375833', '2024-08-29 13:17:32.670', '2024-08-29 13:17:32.670', false, '017f20d0-4f3c-8f4d-9e15-7ff0c3a876d9', '019194ad-db9c-09fc-e0a6-ed4ec8888fb8');

-- Show Search
insert into public.show_search (id, created_at, updated_at, is_deleted, show_id, name)
values  ('019194a9-c1c2-28f5-abb3-c029205ee7bf', '2024-08-28 01:27:18.851', '2024-08-28 01:27:18.851', false, '019194a9-c1b5-407a-fae8-324bc240db6d', '콜드플레이내한공연'),
        ('019194aa-d307-d47f-a08d-b91905345d16', '2024-08-28 01:28:28.808', '2024-08-28 01:28:28.808', false, '019194aa-d2fd-e29f-96c7-df9101dfd1b6', '포스트말론내한공연'),
        ('019194af-d67b-d0f9-1253-c70e1a32f3d0', '2024-08-28 01:33:57.372', '2024-08-28 01:33:57.372', false, '019194af-d678-94df-5fe1-83c3b0d85941', '브루노마스내한공연'),
        ('019194b1-a2b5-bd43-84b0-4209b901cd66', '2024-08-28 01:35:55.190', '2024-08-28 01:35:55.190', false, '019194b1-a2b0-6a29-9d33-d1a4c8fad5cf', '테일러스위프트내한공연'),
        ('01919901-1092-dd7c-9687-1407ba5285cc', '2024-08-28 12:41:09.524', '2024-08-28 12:41:09.524', false, '01919901-105d-b5b2-cbaf-912f20281ce8', '2024오피셜히게단디즘내한공연'),
        ('01919906-7fba-c50f-1e26-27caec7378c4', '2024-08-28 12:47:05.659', '2024-08-28 12:47:05.659', false, '01919906-7fb9-6552-3819-91a5295bb3e6', '올리비아로드리고첫내한공연'),
        ('0191990b-dee6-3fe6-bd3d-2f7f7e6a761a', '2024-08-28 12:52:57.718', '2024-08-28 12:52:57.718', false, '0191948f-0ba0-2a3b-9b19-bd42694ecf58', '코난그레이내한공연'),
        ('01919916-b556-af78-d936-850cc3a9898d', '2024-08-28 13:04:47.979', '2024-08-28 13:04:47.979', false, '019194a4-e4ba-f2d1-79d6-23088c9c3112', '두아리파내한공연'),
        ('01919e32-96f2-290b-fc24-b6f46e5c8021', '2024-08-29 12:53:21.335', '2024-08-29 12:53:21.335', false, '019194ba-562b-a6bc-b7e9-42d21e566111', '벤슨분내한공연'),
        ('01919e38-80c4-8cf2-6550-14f403370751', '2024-08-29 12:59:48.814', '2024-08-29 12:59:48.814', false, '019194b9-a3c3-5cd7-b35d-2c133907812d', '스트록스내한공연'),
        ('01919e3b-bc4f-0d72-9289-a592a9f8a11f', '2024-08-29 13:03:20.672', '2024-08-29 13:03:20.672', false, '019194b8-79f5-e976-7be4-1a07018ad0ee', '크리스토퍼내한공연'),
        ('01919e3e-cbd1-ca55-b1bc-49ccd34596d6', '2024-08-29 13:06:41.242', '2024-08-29 13:06:41.242', false, '019194b7-b2a8-33d0-6f93-dcdcfbd7fdea', 'ajr내한공연'),
        ('01919e41-8d69-d787-6fc6-152709822faf', '2024-08-29 13:09:41.872', '2024-08-29 13:09:41.872', false, '019194b6-bf4a-3f6d-91d5-4de8ab1bf027', '라디오헤드내한공연'),
        ('01919e41-c211-270c-fcff-14d4da10c866', '2024-08-29 13:09:55.359', '2024-08-29 13:09:55.359', false, '019194ac-757e-265a-a639-0f20626ad748', '이브내한공연'),
        ('01919e42-f208-772c-977d-67eda677b979', '2024-08-29 13:11:13.170', '2024-08-29 13:11:13.170', false, '019194b5-d4a3-5186-2ae2-008109252b27', '디스클로저내한공연'),
        ('01919e44-9730-3e33-a7c3-73574ec4b9b0', '2024-08-29 13:13:00.984', '2024-08-29 13:13:00.984', false, '019194ad-1663-4319-c525-12ece13f18ad', '스파이에어내한공연'),
        ('01919e46-6233-e92d-5b03-965e6bf627b7', '2024-08-29 13:14:58.493', '2024-08-29 13:14:58.493', false, '019194b4-e020-8a98-ae34-fc1a6f633c18', '라우브내한공연'),
        ('01919e48-1249-05c7-9afa-4452ece08ee6', '2024-08-29 13:16:49.106', '2024-08-29 13:16:49.106', false, '019194b4-1d54-17c7-196b-8736d867649e', '올리비아딘내한공연'),
        ('01919e48-bc70-0e1f-adbd-bb2b45a74ca2', '2024-08-29 13:17:32.662', '2024-08-29 13:17:32.662', false, '019194ad-db9c-09fc-e0a6-ed4ec8888fb8', '엘르가든내한공연'),
        ('01919e49-a9db-c33d-aeb6-483c3df53531', '2024-08-29 13:18:33.441', '2024-08-29 13:18:33.441', false, '019194b3-7974-5f00-d9cf-7a8632b8e0e9', '저스틴비버내한공연'),
        ('01919e4b-931a-cbe2-56fb-34d2a0139aa9', '2024-08-29 13:20:38.691', '2024-08-29 13:20:38.691', false, '019194ae-9b20-8972-0c7c-81704c1dfc1a', '킹누내한공연'),
        ('01919e4b-bec8-db65-f374-d97be3a3a223', '2024-08-29 13:20:49.873', '2024-08-29 13:20:49.873', false, '019194b2-748c-b8e2-e00b-59d3c98d02c1', '위켄드내한공연'),
        ('01919e4e-c622-6904-85c0-eb75ca4f0f90', '2024-08-29 13:24:08.363', '2024-08-29 13:24:08.363', false, '019194b0-cd60-a404-4151-ec9602666ea9', '찰리푸스내한공연');


-- Show Ticketing Time
insert into public.show_ticketing_time (id, created_at, is_deleted, updated_at, ticketing_at, show_id, type)
values  ('01919901-10ae-8324-814b-92e4613b30ef', '2024-08-28 12:41:09.552', false, '2024-08-28 12:41:09.552', '2024-08-28 21:40:00.000', '01919901-105d-b5b2-cbaf-912f20281ce8', 'NORMAL'),
        ('01919906-7fbd-b22b-822e-5f715f6ada3a', '2024-08-28 12:47:05.662', false, '2024-08-28 12:47:05.662', '2024-05-17 00:00:00.000', '01919906-7fb9-6552-3819-91a5295bb3e6', 'NORMAL'),
        ('0191990e-3c54-47e1-f67b-0cb6257d13fc', '2024-08-28 12:55:32.693', false, '2024-08-28 12:55:32.693', '2024-05-08 00:00:00.000', '0191948f-0ba0-2a3b-9b19-bd42694ecf58', 'NORMAL'),
        ('01919916-b579-20e8-3c67-305ccfdd8b16', '2024-08-28 13:04:47.994', false, '2024-08-28 13:04:47.994', '2024-06-20 00:00:00.000', '019194a4-e4ba-f2d1-79d6-23088c9c3112', 'NORMAL'),
        ('01919e32-97d2-6296-f7a0-3ac09e62531f', '2024-08-29 12:53:21.504', false, '2024-08-29 12:53:21.504', '2024-09-30 21:51:00.000', '019194ba-562b-a6bc-b7e9-42d21e566111', 'NORMAL'),
        ('01919e34-6eee-d768-c7cb-522875f78df1', '2024-08-29 12:55:22.094', false, '2024-08-29 12:55:22.094', '2024-11-13 14:00:00.000', '019194a9-c1b5-407a-fae8-324bc240db6d', 'NORMAL'),
        ('01919e38-80df-3777-7d8b-480b63e3e0b3', '2024-08-29 12:59:48.831', false, '2024-08-29 12:59:48.831', '2024-12-22 21:59:00.000', '019194b9-a3c3-5cd7-b35d-2c133907812d', 'NORMAL'),
        ('01919e3b-bc68-8f33-760f-54c3ebc92a13', '2024-08-29 13:03:20.680', false, '2024-08-29 13:03:20.680', '2024-09-07 22:02:00.000', '019194b8-79f5-e976-7be4-1a07018ad0ee', 'NORMAL'),
        ('01919e3c-3c3a-48d4-483f-71eff44ff89f', '2024-08-29 13:03:53.402', false, '2024-08-29 13:03:53.402', '2024-09-01 14:00:00.000', '019194aa-d2fd-e29f-96c7-df9101dfd1b6', 'NORMAL'),
        ('01919e3e-cbe7-0272-bcae-c32bc50f2c03', '2024-08-29 13:06:41.255', false, '2024-08-29 13:06:41.255', '2024-10-03 22:05:00.000', '019194b7-b2a8-33d0-6f93-dcdcfbd7fdea', 'NORMAL'),
        ('01919e41-8d79-8f51-3260-d081962e73da', '2024-08-29 13:09:41.882', false, '2024-08-29 13:09:41.882', '2024-10-05 22:09:00.000', '019194b6-bf4a-3f6d-91d5-4de8ab1bf027', 'NORMAL'),
        ('01919e41-c22c-742d-c8b4-4f71a721076f', '2024-08-29 13:09:55.373', false, '2024-08-29 13:09:55.373', '2024-09-06 14:00:00.000', '019194ac-757e-265a-a639-0f20626ad748', 'NORMAL'),
        ('01919e42-f220-bec9-3cd9-1c0e18d3e27e', '2024-08-29 13:11:13.185', false, '2024-08-29 13:11:13.185', '2024-09-05 22:10:00.000', '019194b5-d4a3-5186-2ae2-008109252b27', 'NORMAL'),
        ('01919e44-974e-6ce6-a69e-c36641f53b3e', '2024-08-29 13:13:01.006', false, '2024-08-29 13:13:01.006', '2024-09-20 14:00:00.000', '019194ad-1663-4319-c525-12ece13f18ad', 'NORMAL'),
        ('01919e46-624e-54e4-3d15-cefcfd465686', '2024-08-29 13:14:58.511', false, '2024-08-29 13:14:58.511', '2024-09-21 22:14:00.000', '019194b4-e020-8a98-ae34-fc1a6f633c18', 'NORMAL'),
        ('01919e48-1259-9d23-0b35-021557855800', '2024-08-29 13:16:49.114', false, '2024-08-29 13:16:49.114', '2024-09-18 22:16:00.000', '019194b4-1d54-17c7-196b-8736d867649e', 'NORMAL'),
        ('01919e48-bc80-51b4-4275-86aed78a70fa', '2024-08-29 13:17:32.673', false, '2024-08-29 13:17:32.673', '2024-09-13 14:00:00.000', '019194ad-db9c-09fc-e0a6-ed4ec8888fb8', 'NORMAL'),
        ('01919e49-a9f0-b161-d1c5-ade0ad0406c8', '2024-08-29 13:18:33.457', false, '2024-08-29 13:18:33.457', '2024-09-28 22:18:00.000', '019194b3-7974-5f00-d9cf-7a8632b8e0e9', 'NORMAL'),
        ('01919e4b-932a-6d80-5086-8e7d9819ec05', '2024-08-29 13:20:38.698', false, '2024-08-29 13:20:38.698', '2024-09-12 12:00:00.000', '019194ae-9b20-8972-0c7c-81704c1dfc1a', 'NORMAL'),
        ('01919e4b-bee0-5d00-cc20-57c3cf222e9e', '2024-08-29 13:20:49.889', false, '2024-08-29 13:20:49.889', '2024-09-05 22:19:00.000', '019194b2-748c-b8e2-e00b-59d3c98d02c1', 'NORMAL'),
        ('01919e4d-55b0-49a8-589e-56871819f9b2', '2024-08-29 13:22:34.033', false, '2024-08-29 13:22:34.033', '2024-09-21 22:21:00.000', '019194b1-a2b0-6a29-9d33-d1a4c8fad5cf', 'NORMAL'),
        ('01919e4e-b01c-dc6e-a25b-f069e0526324', '2024-08-29 13:24:02.716', false, '2024-08-29 13:24:02.716', '2024-09-24 12:00:00.000', '019194af-d678-94df-5fe1-83c3b0d85941', 'NORMAL'),
        ('01919e4e-c635-3117-baa3-11341f406aac', '2024-08-29 13:24:08.375', false, '2024-08-29 13:24:08.375', '2024-09-09 22:23:00.000', '019194b0-cd60-a404-4151-ec9602666ea9', 'NORMAL');
