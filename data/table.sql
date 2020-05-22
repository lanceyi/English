create table "Questions"
(
	id int auto_increment,
	chapter varchar,
	"topicType" varchar,
	tag varchar,
	topic varchar not null,
	answer varchar,
	prompt varchar,
	constraint QUESTIONS_PK
		primary key (id)
);

comment on table "Questions" is '题目库';

comment on column "Questions".id is 'ID';

comment on column "Questions".chapter is '章节';

comment on column "Questions"."topicType" is '题型';

comment on column "Questions".tag is '标签';

comment on column "Questions".topic is '题目';

comment on column "Questions".answer is '答案';

comment on column "Questions".prompt is '提示';

