'''
Created on Jul 17, 2014

@author: Jared
'''

import praw
import time
import re

if __name__ == '__main__':
    print("STARTING UP BOT...")

    r = praw.Reddit(user_agent='ZOT_BOT')
    r.login('ucivbot2', '574910749b')
    
    # Test link
    # http://www.reddit.com/r/test/comments/2b2y7o/test/
    
    subreddit = r.get_subreddit('uci')
    
    # Set to hold the IDs of all parsed comments
    parsedComments = set()
    
    # Upvote the top 10 hot submissions
#     for comment in subreddit.get_hot(limit=10):
#         comment.upvote()
#         time.sleep(1)

    # Parse the subreddit for 'zot_bot' keyword
    for submission in subreddit.get_hot(limit=1):
        # Get the comments of the submission, returned as a tree, and then flatten them into a iterable list
        flat_comments = praw.helpers.flatten_tree(submission.comments)

        # If the comment has 'ZOT_BOT' in it reply
        for comment in flat_comments:
            if re.match("zot_bot", comment.body) and comment.id not in parsedComments:
                print("Found in '" + comment.body + "'")
                comment.reply("Hello!")
                parsedComments.add(comment.id)
    
    print("BOT ACTIONS COMPLETED")