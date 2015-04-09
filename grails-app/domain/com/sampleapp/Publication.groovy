package com.sampleapp

class Publication {
   String title
   String author
   Date datePublished
   Integer numberOfPages

   static namedQueries = {
       recentPublications {
           def now = new Date()
           gt 'datePublished', now - 7
       }

       oldPublicationsLargerThan { pageCount ->
           def now = new Date()
           lt 'datePublished', now - 7
           gt 'numberOfPages', pageCount
       }

       publicationsWithBookInTitle {
           like 'title', '%Book%'
       }

       recentPublicationsWithBookInTitle {
           // calls to other named queries…
           recentPublications()
           publicationsWithBookInTitle()
      }
   }
}