insert into users_roles
values ('5d0fd008-cfee-4301-ae30-f03244e2e39a', 'USER'),
       ('79bb0f75-3397-4f26-8afa-39e44dc6038f', 'ADMIN');

insert into users
values ('65b65a3d-b0d6-4344-ad21-022bac8ca0c2', 'agata@abv.bg', 'Medin', 'Tarakchiev',
        'ca034dee7f2ab6ec995e1257add7f0521a84039429a33766b568d86f4b4fe038bfc92c783099eeec',
        087729680, '79bb0f75-3397-4f26-8afa-39e44dc6038f');

insert into brands
values ('70d14389-0a78-4239-aecd-79aa5d824e0d', 'KTM'),
       ('77221405-b41c-4933-9602-b0f05029a312', 'Aprillia'),
       ('88f3f9e3-52d6-4659-a2fe-1b86068c88dc', 'Balkan'),
       ('bdedc173-317a-42e6-9cfb-bd312334cb9a', 'Beta'),
       ('7234cff2-e7b9-4c80-8866-60a817211d30', 'BMW'),
       ('545313f6-8eaa-4cae-a931-a03c111e2c52', 'Ducati'),
       ('e94ed4bb-d7f5-4b87-86a8-2c135b29b5a8', 'GASGAS'),
       ('376b432f-f9bd-453e-b0a7-7cfb5fbe7969', 'Harley-Davidson'),
       ('42f98d9a-92b6-405b-a7fb-f3b9708957d7', 'Honda'),
       ('3bca743c-e1e6-45a2-89af-990501d776ba', 'Husqvarna'),
       ('89a81435-276c-4bc6-a7e9-2358c0d8cc86', 'Kawasaki'),
       ('151b9f9c-4167-49b0-89f1-4796a657c2d5', 'Kymco'),
       ('cc5cae4f-29ef-4826-9953-bf55c06b8d6e', 'MV Agusta'),
       ('ee5b58be-e4ae-4054-9790-ccee42bd0ebe', 'Peugeot'),
       ('bab3385c-b7cf-40ab-95e5-eb073ec976aa', 'Piaggio'),
       ('268c56a9-ff1b-4528-b02b-be585482056a', 'Simson'),
       ('f8945747-e830-4ba2-9c96-e613c0bc8b5c', 'Suzuki'),
       ('f734cf84-ca25-441a-8c6e-604a7b7414ad', 'Yamaha');


insert into models(`id`, `name`, `brand_id`)
values ('70d14389-0a78-4239-aecd-79aa5d824e01', 'SX', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e02', 'XC-W', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e03', 'XC', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e04', 'SX-F', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e05', 'EXC-F', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e06', 'XC-F', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e07', 'ENDURO R', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e08', 'DUKE', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e09', 'SMX', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e10', 'ADVENTURE', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e11', 'RC', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e12', 'SM', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e13', 'SUPER DUKE R', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e14', 'DUKE R', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e15', 'ADVENTURE R', '70d14389-0a78-4239-aecd-79aa5d824e0d'),
       ('70d14389-0a78-4239-aecd-79aa5d824e16', 'RS', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e17', 'RSV', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e18', 'RSW', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e19', 'RS CUBE', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e20', 'AF1', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e21', 'RSV4 Factory', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e22', 'TUAREG', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e23', 'SXV', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e24', 'RXV', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e25', 'RX', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e26', 'AMICO', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e27', 'STORM', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e28', 'SCARABEO', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e29', 'SR', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e30', 'PEGASO', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e31', 'ETX', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e32', 'SHIVER', '77221405-b41c-4933-9602-b0f05029a312'),
       ('70d14389-0a78-4239-aecd-79aa5d824e33', 'BALKAN S2', '88f3f9e3-52d6-4659-a2fe-1b86068c88dc'),
       ('70d14389-0a78-4239-aecd-79aa5d824e34', 'BALKAN M', '88f3f9e3-52d6-4659-a2fe-1b86068c88dc'),
       ('70d14389-0a78-4239-aecd-79aa5d824e35', 'BALKAN MK', '88f3f9e3-52d6-4659-a2fe-1b86068c88dc'),
       ('70d14389-0a78-4239-aecd-79aa5d824e36', 'TR', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e37', 'ZERO', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e38', 'SUPER TRIAL', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e39', 'REV', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e40', 'RR', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e41', 'RE', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e42', 'RR-S', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e43', 'RR-LC', 'bdedc173-317a-42e6-9cfb-bd312334cb9a'),
       ('70d14389-0a78-4239-aecd-79aa5d824e44', 'B', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e45', 'C', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e46', 'CS', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e47', 'GS', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e48', 'GT-T', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e49', 'LS', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e50', 'LT', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e51', 'RRr', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e52', 'Rss', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e54', 'RT', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e55', 'SSs', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e56', 'DSERTX', '7234cff2-e7b9-4c80-8866-60a817211d30'),
       ('70d14389-0a78-4239-aecd-79aa5d824e57', 'DIAVEL', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e58', 'HYPERMOTARD', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e59', 'MONSTER', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e60', 'STREETFIGHTER', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e61', 'MULTISTRADA', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e62', 'PANIGALE', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e63', 'SUPERLEGGERA', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e64', 'SUPERSPORT', '545313f6-8eaa-4cae-a931-a03c111e2c52'),
       ('70d14389-0a78-4239-aecd-79aa5d824e66', 'EC', 'e94ed4bb-d7f5-4b87-86a8-2c135b29b5a8'),
       ('70d14389-0a78-4239-aecd-79aa5d824e67', 'XCc', 'e94ed4bb-d7f5-4b87-86a8-2c135b29b5a8'),
       ('70d14389-0a78-4239-aecd-79aa5d824e68', 'DE', 'e94ed4bb-d7f5-4b87-86a8-2c135b29b5a8'),
       ('70d14389-0a78-4239-aecd-79aa5d824e69', 'MC', 'e94ed4bb-d7f5-4b87-86a8-2c135b29b5a8'),
       ('70d14389-0a78-4239-aecd-79aa5d824e70', 'ROAD KING', '376b432f-f9bd-453e-b0a7-7cfb5fbe7969'),
       ('70d14389-0a78-4239-aecd-79aa5d824e71', 'ELECTRA', '376b432f-f9bd-453e-b0a7-7cfb5fbe7969'),
       ('70d14389-0a78-4239-aecd-79aa5d824e72', 'HARITAGE', '376b432f-f9bd-453e-b0a7-7cfb5fbe7969'),
       ('70d14389-0a78-4239-aecd-79aa5d824e73', 'DYNA', '376b432f-f9bd-453e-b0a7-7cfb5fbe7969'),
       ('70d14389-0a78-4239-aecd-79aa5d824e74', 'CBR', '376b432f-f9bd-453e-b0a7-7cfb5fbe7969'),
       ('70d14389-0a78-4239-aecd-79aa5d824e75', 'GOLD WING', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e76', 'VRF', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e77', 'REBEL', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e78', 'MSX', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e79', 'CB', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e80', 'CRF', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e81', 'NC', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e82', 'AFRICA', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e83', 'VISION', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e84', 'PCX', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e85', 'SH', '42f98d9a-92b6-405b-a7fb-f3b9708957d7'),
       ('70d14389-0a78-4239-aecd-79aa5d824e86', 'FC', '3bca743c-e1e6-45a2-89af-990501d776ba'),
       ('70d14389-0a78-4239-aecd-79aa5d824e87', 'TE', '3bca743c-e1e6-45a2-89af-990501d776ba'),
       ('70d14389-0a78-4239-aecd-79aa5d824e88', 'FE', '3bca743c-e1e6-45a2-89af-990501d776ba'),
       ('70d14389-0a78-4239-aecd-79aa5d824e89', 'VITPILEN', '3bca743c-e1e6-45a2-89af-990501d776ba'),
       ('70d14389-0a78-4239-aecd-79aa5d824e90', 'TX', '3bca743c-e1e6-45a2-89af-990501d776ba'),
       ('70d14389-0a78-4239-aecd-79aa5d824e91', 'NINJA', '89a81435-276c-4bc6-a7e9-2358c0d8cc86'),
       ('70d14389-0a78-4239-aecd-79aa5d824e92', 'Z', '89a81435-276c-4bc6-a7e9-2358c0d8cc86'),
       ('70d14389-0a78-4239-aecd-79aa5d824e93', 'VULCAN', '89a81435-276c-4bc6-a7e9-2358c0d8cc86'),
       ('70d14389-0a78-4239-aecd-79aa5d824e94', 'H2R', '89a81435-276c-4bc6-a7e9-2358c0d8cc86'),
       ('70d14389-0a78-4239-aecd-79aa5d824e95', 'ZX-10R', '89a81435-276c-4bc6-a7e9-2358c0d8cc86'),
       ('70d14389-0a78-4239-aecd-79aa5d824e96', 'COBRA', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824e97', 'KB', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824e98', 'AK', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824e99', 'ACTIV', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824100', 'CARO', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824101', 'CHERRY', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824102', 'DINK', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824103', 'EASY', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824104', 'PEOPLE', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824105', 'SENTO', '151b9f9c-4167-49b0-89f1-4796a657c2d5'),
       ('70d14389-0a78-4239-aecd-79aa5d824106', 'RUSH', 'cc5cae4f-29ef-4826-9953-bf55c06b8d6e'),
       ('70d14389-0a78-4239-aecd-79aa5d824107', 'BRUTALE', 'cc5cae4f-29ef-4826-9953-bf55c06b8d6e'),
       ('70d14389-0a78-4239-aecd-79aa5d824108', 'DRAGSTER', 'cc5cae4f-29ef-4826-9953-bf55c06b8d6e'),
       ('70d14389-0a78-4239-aecd-79aa5d824109', 'TURISMO VELOCE', 'cc5cae4f-29ef-4826-9953-bf55c06b8d6e'),
       ('70d14389-0a78-4239-aecd-79aa5d824110', 'F3', 'cc5cae4f-29ef-4826-9953-bf55c06b8d6e'),
       ('70d14389-0a78-4239-aecd-79aa5d824111', 'SUPERVELOCE', 'cc5cae4f-29ef-4826-9953-bf55c06b8d6e'),
       ('70d14389-0a78-4239-aecd-79aa5d824113', 'SC', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824114', 'S', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824115', 'BUXY', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824116', 'RAPIDO', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824117', 'SATELIS', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824118', 'BELVILE', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824119', 'PUISION', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824120', 'KISBEE', 'ee5b58be-e4ae-4054-9790-ccee42bd0ebe'),
       ('70d14389-0a78-4239-aecd-79aa5d824121', 'FLY', 'bab3385c-b7cf-40ab-95e5-eb073ec976aa'),
       ('70d14389-0a78-4239-aecd-79aa5d824122', 'BEVERLY', 'bab3385c-b7cf-40ab-95e5-eb073ec976aa'),
       ('70d14389-0a78-4239-aecd-79aa5d824123', 'LIBERTY', 'bab3385c-b7cf-40ab-95e5-eb073ec976aa'),
       ('70d14389-0a78-4239-aecd-79aa5d824124', 'MEDLEY', 'bab3385c-b7cf-40ab-95e5-eb073ec976aa'),
       ('70d14389-0a78-4239-aecd-79aa5d824125', 'VESPA', 'bab3385c-b7cf-40ab-95e5-eb073ec976aa'),
       ('70d14389-0a78-4239-aecd-79aa5d824126', 'SRR', '268c56a9-ff1b-4528-b02b-be585482056a'),
       ('70d14389-0a78-4239-aecd-79aa5d824127', 'AWO', '268c56a9-ff1b-4528-b02b-be585482056a'),
       ('70d14389-0a78-4239-aecd-79aa5d824128', 'SL', '268c56a9-ff1b-4528-b02b-be585482056a'),
       ('70d14389-0a78-4239-aecd-79aa5d824129', 'KR', '268c56a9-ff1b-4528-b02b-be585482056a'),
       ('70d14389-0a78-4239-aecd-79aa5d824130', 'Ss', '268c56a9-ff1b-4528-b02b-be585482056a'),
       ('70d14389-0a78-4239-aecd-79aa5d824131', 'KATANA', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824132', 'GSV-R', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824133', 'T', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824134', 'GT', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824135', 'AVENIS', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824136', 'GSX', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824138', 'HAYABUSA', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824139', 'RG', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824140', 'GIXXER', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c'),
       ('70d14389-0a78-4239-aecd-79aa5d824141', 'V-STORM', 'f8945747-e830-4ba2-9c96-e613c0bc8b5c');

insert into parts_categories
values ('2240cd9f-bcba-40c8-a0ab-03fceab5f02a', 'TYRES'),
       ('3c35a23b-c230-4874-835e-648a8005b936', 'BRAKESYSTEM'),
       ('40ccd09a-6167-4c7b-bcfb-cf4d4af4675d', 'PLASTICS'),
       ('5677c10b-f481-47bf-830c-f160bd28b8e5', 'ACCESSORIES'),
       ('8d501921-3045-4667-800b-7420b12d7064', 'SUSPENSION'),
       ('8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc', 'ENGINE'),
       ('deae8d73-b6c7-42f6-918c-0748fae51629', 'OIL');

insert into parts_sub_categories
values ('0081678c-3592-4db9-b6cb-e3544ad54d9a', 'Crankshaft', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('1d2d6104-17cb-429c-8188-9c91af4cb107', 'Camps', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('1ef4517b-beb0-45a7-83c6-f6bf4cad76fe', 'Suspension Oil', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('26ed5ef8-0962-44d4-9ae5-0813bc88043a', 'Brake Hose', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('319c1763-83a9-4487-9499-eee4eddf7fde', 'Piston', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('3658ed4e-c035-439c-8930-1d2a2a5a4a9a', 'Brake Device', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('3ea3eb15-d25a-4a25-a3ea-dcc0c6454edc', 'Engine Oil', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('5ffbe51f-123e-444a-a054-8dae80786fbb', 'Springs', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('6d705c9e-9635-491c-8af8-6b571b35c331', 'Cross Tyres', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('712a5fb5-a5b3-4654-ac50-2c452f4c138c', 'Cover', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('7fae398f-47c1-4179-ba23-df23e7ffbc7d', 'Segments', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('907fee3f-4f9c-4b05-9ce6-e8e1955b5aa3', 'Valves', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('a7d14482-81b8-4db9-a789-1883036e1842', 'Cylinder', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('c076ed51-e980-4ab5-8620-0f4985766e3e', 'RoadTires', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('c563e693-070f-402f-b8c1-7e3b42929c94', 'Brake fluid', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('cb495987-2695-491b-88a3-50073fe61c95', 'Rear Shock', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('d2fa7a4f-6882-4ac4-9c79-259630f257da', 'Chain Drive', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('d90d26b5-3c43-4f6d-8586-133e7d789910', 'Transmission Oil', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('d2fa7a4f-6882-4ac4-9c79-259630f257d2', 'Fork', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('f810cb9c-cb90-4cb0-bf3a-c54ddb5c9240', 'Front Shock', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('f9e70fb7-9d9c-4d6c-bdf6-39f02da8a56b', 'Pads', '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc');

insert into parts
values ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a561', 'Engine Oil Motul 4l 15w60',
        'https://i.ebayimg.com/images/g/I6AAAOSwSRNg4qk2/s-l1600.jpg', 'Motul 15w60 4l', 150,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a562', 'Engine Oil Motul 1l 15w60',
        'https://i.ebayimg.com/images/g/9jgAAOSwrKli4We3/s-l500.jpg', 'Motul 15w60 1l', 32,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a563', 'Engine Oil Motul 4l 10w40',
        'https://i.ebayimg.com/images/g/M~gAAOSwTMVg3YRr/s-l500.png', 'Motul 10w40 4l', 145,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a564', 'Engine Oil Motul 1l 10w40',
        'https://i.ebayimg.com/images/g/guEAAOSwxlFg3YR1/s-l1600.png', 'Motul 10w40 1l', 29,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a565', 'Brake Device Brembo for Ktm',
        'https://i.ebayimg.com/images/g/IyEAAOSwLuldg4KF/s-l1600.jpg', 'Brembo Brake Device', 344,
        '3c35a23b-c230-4874-835e-648a8005b936'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a566', 'Brake Device Brembo for Honda',
        'https://i.ebayimg.com/images/g/IyEAAOSwLuldg4KF/s-l1600.jpg', 'Brake Device Honda', 290,
        '3c35a23b-c230-4874-835e-648a8005b936'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a567', 'Brake Device Brembo for Yamaha',
        'https://i.ebayimg.com/images/g/IyEAAOSwLuldg4KF/s-l1600.jpg', 'Brembo Brake Device Yamaha', 300,
        '3c35a23b-c230-4874-835e-648a8005b936'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a568', 'Brake Device Brembo for Suzuki',
        'https://i.ebayimg.com/images/g/IyEAAOSwLuldg4KF/s-l1600.jpg', 'Brembo Brake Device Suzuki', 275,
        '3c35a23b-c230-4874-835e-648a8005b936'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a569', 'Piston for Ktm',
        'https://i.ebayimg.com/images/g/OJcAAOSwTLRfMT06/s-l1600.jpg', 'Piston for Ktm', 632,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a510', 'Piston for Honda',
        'https://i.ebayimg.com/images/g/OJcAAOSwTLRfMT06/s-l1600.jpg', 'Piston for Honda', 570,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a511', 'Piston for Ducati',
        'https://i.ebayimg.com/images/g/OJcAAOSwTLRfMT06/s-l1600.jpg', 'Piston for Ducati', 850,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a512', 'Piston for Suzuki',
        'https://i.ebayimg.com/images/g/OJcAAOSwTLRfMT06/s-l1600.jpg', 'Piston for Suzuki', 644,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a513', 'Suspension Oil FOX',
        'https://i.ebayimg.com/images/g/olIAAOSw3KRi1qj-/s-l1600.jpg', 'Fox oil', 40,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a514', 'Crankshaft for CRF 450',
        'https://i.ebayimg.com/images/g/8R4AAOSwNJRgPbNF/s-l1600.png', 'Crankshaft Honda', 555,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a515', 'Crankshaft for ktm 450',
        'https://i.ebayimg.com/images/g/8R4AAOSwNJRgPbNF/s-l1600.png', 'Crankshaft Ktm', 435,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a516', 'Crankshaft for Kawasaki 450',
        'https://i.ebayimg.com/images/g/8R4AAOSwNJRgPbNF/s-l1600.png', 'Crankshaft Kawasaki', 374,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a517', 'Crankshaft for CRF 250',
        'https://i.ebayimg.com/images/g/8R4AAOSwNJRgPbNF/s-l1600.png', 'Crankshaft Honda 250', 468,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a518', 'Springs Rear Shock',
        'https://i.ebayimg.com/images/g/2oYAAOSwVh5hSb4I/s-l1600.jpg', 'Rear Shock', 249,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a519', 'Springs front Shock Ohlins',
        'https://i.ebayimg.com/images/g/zi0AAOSwax1dlHxG/s-l1600.jpg', 'Rear Shock Ohlins', 399,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a520', 'Springs front Shock',
        'https://i.ebayimg.com/images/g/zi0AAOSwax1dlHxG/s-l1600.jpg', 'Front Shock Ohlins', 199,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a521', 'Front Shock Honda CBR 1000',
        'https://i.ebayimg.com/images/g/hboAAOSwj59hzgZC/s-l1600.jpg', 'Front Shock KYB', 1800,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a522', 'Front Shock KTM',
        'https://i.ebayimg.com/images/g/K5sAAOSwg3Vity-J/s-l1600.jpg', 'Front Shock WP', 1140,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a122', 'Front Shock Kawasaki',
        'https://i.ebayimg.com/images/g/K5sAAOSwg3Vity-J/s-l1600.jpg', 'Front Shock', 1237,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a111', 'Front Shock',
        'https://i.ebayimg.com/images/g/K5sAAOSwg3Vity-J/s-l1600.jpg', 'Front Shock', 1200,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a523', 'Front and Rear Motocross Tyres 80/100/21 120/90 18',
        'https://i.ebayimg.com/images/g/kf8AAOSwTpZgm5NH/s-l1600.jpg', 'Mitas Tyres', 90,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a524', 'Front and Rear Motocross Tyres 80/110/21 110/90 18',
        'https://i.ebayimg.com/images/g/kf8AAOSwTpZgm5NH/s-l1600.jpg', 'Michelin Tyres', 88,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a525', 'Front and Rear Motocross Tyres 80/120/21 120/90 19',
        'https://i.ebayimg.com/images/g/kf8AAOSwTpZgm5NH/s-l1600.jpg', 'Mitas Tyres', 93,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a526', 'Front and Rear Motocross Tyres 80/100/21 120/90 19',
        'https://i.ebayimg.com/images/g/kf8AAOSwTpZgm5NH/s-l1600.jpg', 'Mitas Tyres', 99,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a527', 'Front and Rear Motocross Tyres 80/100/21 110/90 18',
        'https://i.ebayimg.com/images/g/kf8AAOSwTpZgm5NH/s-l1600.jpg', 'Toyo Tyres', 103,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a528', 'Front and Rear Sport Tyres 110/70/17',
        'https://i.ebayimg.com/images/g/gjcAAOSw84ZcD9Lt/s-l1600.jpg', 'Dunlop Tyres', 160,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a529', 'Front and Rear Sport Tyres 120/70/17',
        'https://i.ebayimg.com/images/g/gjcAAOSw84ZcD9Lt/s-l1600.jpg', 'Dunlop Tyres', 156,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a530', 'Front and Rear Sport Tyres 110/60/17',
        'https://i.ebayimg.com/images/g/gjcAAOSw84ZcD9Lt/s-l1600.jpg', 'Pirelli Tyres', 151,
        '2240cd9f-bcba-40c8-a0ab-03fceab5f02a'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a531', 'segments for piston',
        'https://i.ebayimg.com/images/g/SZ0AAOSwRXRZOcKt/s-l1600.jpg', 'Segments 1', 9,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a532', 'segments for piston',
        'https://i.ebayimg.com/images/g/SZ0AAOSwRXRZOcKt/s-l1600.jpg', 'Segments 2', 12,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a533', 'segments for piston',
        'https://i.ebayimg.com/images/g/SZ0AAOSwRXRZOcKt/s-l1600.jpg', 'Segments 4', 15,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a534', 'Valves Ktm',
        'https://i.ebayimg.com/images/g/iD0AAOSwIVhaHFYD/s-l1600.jpg', 'Valves', 233,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a535', 'Valves Honda',
        'https://i.ebayimg.com/images/g/iD0AAOSwIVhaHFYD/s-l1600.jpg', 'Valves', 188,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a536', 'Valves Husaberg',
        'https://i.ebayimg.com/images/g/iD0AAOSwIVhaHFYD/s-l1600.jpg', 'Valves', 246,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a537', 'Valves Kawasaki',
        'https://i.ebayimg.com/images/g/iD0AAOSwIVhaHFYD/s-l1600.jpg', 'Valves', 190,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a538', 'Valves Yamaha',
        'https://i.ebayimg.com/images/g/iD0AAOSwIVhaHFYD/s-l1600.jpg', 'Valves', 187,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a539', 'Cylinder 450cc Yamaha',
        'https://i.ebayimg.com/images/g/4p0AAOSwwzRiYnUI/s-l1600.jpg', 'Cylinder Yamaha', 137,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a540', 'Cylinder 250cc Yamaha',
        'https://i.ebayimg.com/images/g/4p0AAOSwwzRiYnUI/s-l1600.jpg', 'Cylinder Yamaha', 177,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a541', 'Cylinder 450cc Ktm',
        'https://i.ebayimg.com/images/g/4p0AAOSwwzRiYnUI/s-l1600.jpg', 'Cylinder Ktm', 147,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a542', 'Cylinder 350cc ktm',
        'https://i.ebayimg.com/images/g/4p0AAOSwwzRiYnUI/s-l1600.jpg', 'Cylinder Ktm', 130,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a543', 'Cylinder 450cc Honda',
        'https://i.ebayimg.com/images/g/4p0AAOSwwzRiYnUI/s-l1600.jpg', 'Cylinder Honda', 123,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a544', 'Full Engine Covers',
        'https://i.ebayimg.com/images/g/wIwAAOSwg5NhuGuN/s-l1600.jpg', 'Engine Covers', 51,
        '8f1d79b4-e5dd-4b26-82ab-ac520cbb6fbc'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a545', 'Brake Fluid',
        'https://i.ebayimg.com/images/g/T-kAAOSw6Oti6sYI/s-l1600.jpg', 'Brake Fluid', 22,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a546', 'Brake Fluid',
        'https://i.ebayimg.com/images/g/2uMAAOSwsnVdl7G9/s-l1600.png', 'Brake Fluid premium', 32,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a547', 'DID Drive Chain GOLD',
        'https://i.ebayimg.com/images/g/U7oAAOSw53Zh9b~6/s-l1600.png', 'Did Drive Chain GOLD', 73,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a548', 'DID Drive Chain',
        'https://i.ebayimg.com/images/g/U7oAAOSw53Zh9b~6/s-l1600.png', 'Did Drive Chain', 53,
        '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a549', 'Transmission Oil',
        'https://i.ebayimg.com/images/g/HCkAAOSwIftfVy6d/s-l1600.jpg', 'Transmission fluid', 111,
        'deae8d73-b6c7-42f6-918c-0748fae51629'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a550', 'Fork', 'https://i.ebayimg.com/images/g/l~4AAOSwYY1eVmXU/s-l1600.jpg',
        'Fork', 587, '8d501921-3045-4667-800b-7420b12d7064'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a551', 'Plastic ktm 450',
        'https://i.ebayimg.com/images/g/YXUAAOSw61hihQmc/s-l1600.jpg', 'Orange Plastic Ktm', 199,
        '40ccd09a-6167-4c7b-bcfb-cf4d4af4675d'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a552', 'Plastic + Graphics ktm 450',
        'https://i.ebayimg.com/images/g/F1gAAOSwHU9iswj1/s-l1600.jpg', 'Black Plastic Ktm', 299,
        '40ccd09a-6167-4c7b-bcfb-cf4d4af4675d'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a553', 'Plastic complete Honda',
        'https://i.ebayimg.com/images/g/m3kAAOSwIyZix6cV/s-l1600.jpg', 'Red Plastic Honda', 499,
        '40ccd09a-6167-4c7b-bcfb-cf4d4af4675d'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a554', 'Plastic complete Honda CBR',
        'https://i.ebayimg.com/images/g/TRYAAOSw0Ohi58jA/s-l1600.jpg', 'Plastic Honda', 723,
        '40ccd09a-6167-4c7b-bcfb-cf4d4af4675d'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a555', 'Plastic Repsol Honda CBR',
        'https://i.ebayimg.com/images/g/gy8AAOSwZ3Ni58wv/s-l1600.jpg', 'Plastic Honda Repsol', 483,
        '40ccd09a-6167-4c7b-bcfb-cf4d4af4675d'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a556', 'Plastic Yamaha YZF',
        'https://i.ebayimg.com/images/g/3HQAAOSweqNgPcN0/s-l1600.jpg', 'Blue Plastic Yamaha', 630,
        '40ccd09a-6167-4c7b-bcfb-cf4d4af4675d'),
       ('aa6c77gg-9d9c-4d6c-bdf6-39f02da8a557', 'Plastic Yamaha YZF',
        'https://i.ebayimg.com/images/g/IZgAAOSwE~1b6SDK/s-l1600.jpg', 'Black Plastic Yamaha', 530,
        '40ccd09a-6167-4c7b-bcfb-cf4d4af4675d');