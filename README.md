# 学生日程规划平台

> 本项目正在开发中，预计开发周期一个月（开发后视情况维护，主要为学校大作业使用）
> 
> 开发文档：https://schedule-planning-platform.pages.dev/
> 接口文档：https://schedule-planning-platform.apifox.cn

![Alt](https://repobeats.axiom.co/api/embed/e2ee20c8a5dc11d8d665a835c5eb857a92aa2a57.svg "Repobeats analytics image")

## 简介

### 文档目的

学生日程规划平台旨在为学生提供一个全面、高效的日程管理工具，帮助他们合理规划学习与生活，提高时间管理能力。通过该平台，学生可以轻松创建和管理个人日程、添加和查看课程表，同时与好友建立联系，互相查询彼此的空闲时间。平台具备用户友好的界面和强大的功能，满足学生在学习期间的多样化需求，助力他们实现自我管理和高效学习。

### 项目背景与目标

在学校团队合作或竞赛中，学生之间需要频繁地进行沟通和协作。然而，由于每个人的时间安排各异，口头沟通确认时间往往变得困难，导致效率低下。为了解决这个问题，我们决定开发一套系统，为学生提供可视化的时间安排工具。该系统将帮助学生更方便地查看和协调彼此的时间安排，提高团队沟通效率，促进协作。



## 系统概述

### 平台简介

学生日程规划平台是一个专为学生设计的时间管理工具，旨在提供一个集日程规划、课程表管理和好友互动于一体的综合性解决方案。通过该平台，学生可以直观地管理个人日程，查看课程安排，并与好友共享时间表，从而更有效地安排学习和生活。同时，好友系统的引入，让学生能够方便地查询好友的空闲时间，促进团队合作和沟通效率。

### 系统架构概览

> 系统架构采用了前后端分离的设计，以提高开发效率和系统的可扩展性：

- **前端**：基于 React 框架开发，实现了丰富的用户界面和交互功能，包括日程规划、课程表展示和好友系统等模块。前端通过RESTful API与后端进行数据交互，提供流畅的用户体验。
- **后端**：使用 Spring Boot 框架开发，实现核心业务逻辑和数据处理。后端负责处理来自前端的请求，包括日程管理、课程表操作、好友查询等功能，并与数据库进行交互，确保数据的准确性和安全性。
- **数据库**：采用 PostgreSQL 进行数据存储，负责保存用户数据、日程信息、课程表和好友关系等。数据库设计注重数据完整性、性能和安全，支持高效的数据查询和处理。

### 主要功能一览

- **日程规划**：提供日程创建、编辑、删除等功能，支持按天、周、月查看日程。用户可以设置提醒，确保重要任务不会被遗漏。
- **课程表管理**：允许学生添加、编辑和删除课程信息，包括课程的时间、地点和教师信息。支持课程表的导入和导出，方便用户管理自己的学习计划。
- **好友系统**：提供好友添加和管理功能。用户可以查询好友的日程安排，了解对方的空闲时间，便于团队合作和沟通，提高学习和活动的组织效率。



## 主要功能

### 日程规划

- **创建、编辑、删除日程**：学生可以轻松创建新的日程安排，并对已有日程进行编辑或删除。通过简洁的操作界面，用户可以快速添加日程内容、设置开始和结束时间，以及添加备注等详细信息。
- **日程提醒与通知**：提供日程提醒功能，用户可以为重要的日程设置提醒，系统会在指定的时间发送通知，确保学生不会错过关键事项，提高时间管理效率。
- **日程查看（按天、周、月）**：支持多视图方式查看日程，包括按天、周、月查看，帮助用户以不同的时间跨度了解自己的日程安排，更直观地进行时间规划。

### 课程表管理

- **添加、编辑、删除课程**：学生可以方便地添加课程信息，包括课程名称、时间、地点和教师信息等。系统允许对课程信息进行编辑或删除，以便于学生根据实际情况调整课程表。
- **课程时间、地点、教师信息**：在添加课程时，用户可以输入详细的课程时间、地点和教师信息，帮助学生更好地组织和管理自己的学习计划。
- **课程表导入/导出功能**：提供课程表的导入和导出功能，学生可以将自己的课程表导入系统，或将系统中的课程表导出为文件，方便在不同设备或平台上查看。

### 好友系统

- **添加、删除好友**：用户可以通过搜索添加其他学生为好友，并可以随时删除好友。好友关系的建立为学生之间的交流和合作提供了便利。
- **好友分组管理**：支持将好友进行分组管理，例如将好友分为不同的组别（如同学、社团成员等），方便用户根据需要查看和管理好友列表。
- **好友日程查询功能（查看好友是否有空闲时间）**：用户可以查看好友的日程安排，查询对方在特定时间段是否有空闲。这一功能方便学生之间的沟通和合作，特别适用于团队项目和集体活动的时间协调。