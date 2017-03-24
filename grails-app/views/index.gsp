<!doctype html>
<html>
<head>

    <meta name="layout" content="main"/>
    <title>Welcome to ResuMe</title>
    <asset:stylesheet src = "styleSheet.css"/>

</head>


<div class = "Shadow-Box">
    <tab><h1 class = "heading">Begin Creating Your ResuMe</h1></tab>
    <tab><a href = "/userAccount">To start, please sign up here</a></tab>
</div>

<h1>ResuMe! Resume Editor and Sharing Site</h1>
<p1>
    Incorporating elements from websites like LinkedIn, Indeed.com and myperfectresume.com, this system will allow job searchers to custom-build resumes based on their occupational field and interests. We will use a front-end web interface produced with Angular JS and Grails. Users begin with a profile page including basic information such as their name, occupational field, and job preferences. This information is then submitted to an SQL-implemented database, where the user is matched with a host of templates, based on the information submitted through their profile.
    After a template is chosen, the site guides the user through the process of building and editing their resume. When finished, the user can use a variety of features such as a grammar/spellcheck based on the Grammarly API or receive a rating of their resumes’ quality based on its contents with suggestions for improvement targeted to their occupation. An algorithm for the latter will be based off LinkedIn’s profile scoring system. After this step, the user can download it in a specified format, share it on social platforms for employers to view, or add it to their profile.
</p1>
<h2>Additional Features</h2>
<p2>
    <br>Job Offerings and Suggested Certifications.</br>
The website also offers to compare resumes to job postings, such that the site could suggest jobs to users based on the data in their resume and profile. Job offerings can be found via third party websites (ie. Canada Job Bank, Kijiji) with automated queries to third-party search engines. Job offerings would be searched and displayed based on date, proximity to user, and salary.
The same software developed for producing job suggestions could be leveraged to suggest certifications to users. A small database of common profession-specific certifications could be produced. If a user submits a resume for a given profession that lacks mention of this certification, a message (in the form of a pop-up, or in a user inbox) could be sent to the user to offer certifications. Clicking on the link in this message would redirect to the Certifications page, which would then allow the user to search for certifications in their profession category based on proximity, cost, time, and date. For example: First-Aid certification is required for any athletics, nursing, or child-care positions. Heart and Stroke and St. John’s Ambulance have a search engine for finding these courses. This site could aggregate results and make suggestions.
In addition, feature like using Google Maps to chart where jobs or certification courses are, is likely to be implemented in the website.
    <br>Application.</br>
If the User decides to apply for a job suggestion, she leaves the site by clicking on a button marked ‘Apply’ (which will hold a URL to the third-party job-site). The site will save this URL and the date it was used under an Applications Tab.
    <br>Messages Inboxing.</br>
If the database is searchable by employers, this could enable them to leave messages directly on the site for users, or it could allow users to store site notifications in a convenient place. It would be more or less an array of Message objects, and easy to implement on the backend.
</p2>
</body>
</html>
