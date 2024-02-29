# Search Engine

## Overview

Greetings from a search engine website! Here, we retrieve information from websites and present it to the user. Additionally, we have the ability to display a user's search history on the search engine.

## Table of Contents

1. [Introduction](#introduction "Introduction")
2. [Technologies](#technologies "Technologies")
3. [Description](#description "Description")
4. [Website Images](#website-images)


## Introduction:

An effective tool for finding information and other stuff on the internet is a search engine. With this project, we hope to learn more about the inner workings of a basic search engine by creating one from the ground up. To enable effective data retireival, the search engine will use Term Frequencies (TFs) in its indexer web crawling operation.

## Technologies:

* FrontEnd - HTML, CSS, JSP
* BackEnd - Java Servlets
* Database - MySQL
* Others - IntelliJ IDEA, Maven Archtype, Tomcat Server, JDBC(ConnectorJ)

## Description:

**A.** The front end, back end, and database are the main parts of our search engine project.

   * The user interface, which includes a search bar and search button for users to interact with the search engine, is handled by the frontend.

   * The server-side operations are managed by the backend, which also processes user requests and produces pertinent responses.

   * The information that the search engine will utilize to retrieve results is kept and managed by the database.

**B.** A web application with a straightforward search bar and search button is part of the frontend design. The backend analyzes the search request when users input their queries and click the search button. Using a ranking algorithm, it retrieves the top 30 results based on the user's query. Users' search histories are also shown, enabling them to maintain a record of their prior searches.

**C.** The Search Engine will use a client-server architecture, in which requests are sent from the front end (client) to the back end (server), which responds with pertinent information. This relationship is analogous to a patron placing an order with a waiter at a restaurant, and the waiter sending the order to the kitchen (backend) for processing.

**D.** Putting in place a web crawler is a big element of the project. A web crawler is a type of bot that automatically searches websites and retrieves information to add to the search engine's database. The web crawler systematically scans online pages using an algorithm known as Limited Depth-First Search (DFS).

**E.** By designing the web application, implementing web crawlers, and configuring the database, we hope to build a productive search engine that can get pertinent search results in response to user queries and offer a smooth user experience.

## Website Images

Main Page:
![Screenshot (654)](https://github.com/puja664466/SearchEngine/assets/96064811/0e7063b0-2f53-4f2c-9dc9-930544a3e021)

Search Page:
![Screenshot (655)](https://github.com/puja664466/SearchEngine/assets/96064811/013091a6-f590-470b-9900-f5aed5a8da5c)



