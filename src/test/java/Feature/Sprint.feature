Feature: Verify Profile section of Elearning site

  Background: Login Functionality
    Given User is on Elearning site
    When User enters username and password
    And click on Login button
    Then User is redirected to the homepage

  @compose1
  Scenario Outline: Verify messaging functionality
    When User clicks on the compose link
    When User enters "<toname>" in sendto box
    And User selects the receiver name
    And User enters subjectline "<subject>" in subject field
    And User enter texts "<textmsg>" in the message box
    And User enter data in the "<desc>" Description box
    And User clicks send message button
    Then User gets confirmation message

    Examples: 
      | toname | subject              | textmsg                        | desc                |
      | vir    | Automation Script    | I want to automate the website | Image1 not attached |
      | xyz    | Elearning automation | The Website title is Elearning | Image2 not attached |
      | sub    | Testing mail1        |                                |                     |

  @Inbox_searchbutton
  Scenario Outline: verify the messages received in Inbox
    When User click on Inbox link
    Then User can able to see the messages received
    When User enters text "<text>" in search box
    And clicks the Search button
    Then User is displayed with respective message
    When User clicks on the select all button
    And User clicks the unselect all button

    Examples: 
      | text    |
      | testing |

  @Inbox_read
  Scenario: verify Mark as Read and Unread option in Inbox
    When User clicks the Inbox link
    When User click on select all button
    And User clicks Detail dropdown
    And User clicks the Mark as Read option
    And User accepts alert message from alert box
    Then User gets confirmation text
    When User click on select all button
    When User click Detail dropdown
    And User clicks the Mark as Unread option
    And User accept the alert message from alert box
    Then User gets a confirmation message

  @Inbox_reply
  Scenario Outline: verify the reply option in Inbox
    When User clicks on the Inbox link
    When User clicks on Reply option of particular message
    And User enter "<descrip>" in Description box
    And User clicks Send message
    Then User gets success message

    Examples: 
      | descrip          |
      | Image1 not found |

  @Inbox_forward
  Scenario Outline: verify the Forward option in Inbox
    When User clck Inbox link
    When User clicks on Forward option from Edit
    And User enters "<sendname>" toname in Message box
    Then User select the receiver name
    And User enters "<descrip>" in Description box
    And User click Send message button
    Then User gets validation message.

    Examples: 
      | sendname | descrip           |
      | vir      | Forwarded message |

  @Inbox_Composebutton
  Scenario: verify composemessage button in Inbox page
    When User clicks on Inbox link
    When User clicks on Composemessage link
    And User clicks the back button
    Then User navigates to the inbox section

  @Inbox_Outboxbutton
  Scenario Outline: verify the Outbox functionality of Inbox page
    When User clicks Inbox link
    When User clicks on Outbox link
    Then User can able to see the "<validatemsg>" messages sent
    When User clicks on select all button
    And User clicks the unselect all button
    Then User clicks back button

    Examples: 
      | validatemsg |
      | Messages    |

  @OutboxDel
  Scenario Outline: Verify Delete option in Outbox Link
    When User clicks on Inbox tab
    When User clicks on Outbox link
    When User clicks on the select all button
    And User clicks the Detail dropdown
    And User clicks the Delete Selected messages option
    And User accepts the alert message from alert box
    Then User gets a confirmation "<message>"

    Examples: 
      | message        |
      | Back to outbox |

  @InvitationSentPI
  Scenario: Verify the Sent invitations can be viewed from Pending Invitations
    When User clicks on Pending Invitation link
    Then User is displayed with the Invitations sent

  @PendingInvitation
  Scenario Outline: Verify the functionality of Pending Invitation
    When User clicks on Pending Invitation
    When User clicks Try and Find Some Friends button
    When User enter name in "<user>" User,Group box
    When User choose an option from Type dropdown
    And User clicks on search button
    Then User is displayed with the result
    When User clicks the Send Invitation button
    And User enters message "<msg>" in the textbox
    And User clicks the Send message button
    Then User gets the confirmation message

    Examples: 
      | user | msg                         |
      | vir  | Please accept my invitation |

  @SendmsgPending
  Scenario Outline: Verify the send message functionality of Pending Invitation
    When User clicks Pending Invitation link
    When User click Try and Find Some Friends button
    When User enters name in "<User>" User,Group box
    When User choose an option from Type dropDown
    And User clicks search button
    Then User displayed with the result
    When User clicks Send Message button
    And User enters subject "<sub>" in the subjectbox
    And User enter message "<msg1>" in the textbox
    And User click the Send message button
    Then User is displayed with confirmation message

    Examples: 
      | User  | sub        | msg1             |
      | virat | Invitation | Hi, Gud morning! |

  @PersonalData
  Scenario: Verify the Personal Data page
    When User clicks on Personal Data link
    Then User can find the PersonalData Introduction
    When User clicks on PersonalData we keep about you link
    And User expands some of the data
    Then User is displayed with Terms and Conditions if available

  @EditprofileinPD
  Scenario: Verify Edit profile option in Personal Data page
    When User clicks on Personal Data link
    When User clicks on Edit profile link
    Then User verifies the Edit option is accessible from Personaldata page

  @EditProfile
  Scenario: Verify Parameters are filled by default in Edit profile
    When User clicks Edit profile link
    And User verifies Firstname, Lastname, Username, code and email is filled by default

  @passwordchange
  Scenario Outline: Verify password change functionality
    When User clicks on the Edit profile link
    When User enters old password "<pass0>" in Pass textbox
    When User enters new password "<pass1>" in NewPassword field
    When User enters new password "<pass2>" in ConfirmPassword field
    And User clicks on Save Settings button
    Then User is displayed with success "<messages>" message

    Examples: 
      | pass0     | pass1     | pass2     | messages                        |
      | vaish@123 | vaish@123 | vaish@123 | Your new profile has been saved |
