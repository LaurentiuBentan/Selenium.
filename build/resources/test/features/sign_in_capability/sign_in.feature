Feature: sign in feature
#aici punem toate testele care au legatura cu zona de sing in
#dupa feature: se descrie in linii mari capabilitatile aplicatiei in aceasta zona
#@smokeTest este un tag, care e specificat la rularea testelor(permite sa controlam ce teste vrem sa rulam); practic grupeaza testele
#tagurile posibile sunt in build.gradle
#gradle este un tool care compileaza proiectul si aduce dependintele necesare(ex: serenity, selenium, assert)
#serenity.properties: aici setam propietatile de care are nevoie serenity(unde se afla chrome driver.exe, url de pornire)
#nu uita sa creezi capability runner pentru fiecare folder de capabilitati
#configuratorul de sus din dreapta ne ajuta sa pornim testele(click+edit configurations)
#tasks: ":laurentiu aggregate"
#VM options: "-Dwebdriver.driver=chrome"
#Arguments: "--tests "web.SignInCapabilityRunner" "

#! pages->steps->step definition->fisier.feature(testele efective)->capability runner

  #aici punem toti pasii de inceput care se repta intre teste; ei se vor rula inainte de fiecare test
  Background:
    Given sign in: I am a user on sign in page

   #dupa scenario: se specifica titlul test case-ului
  @laurentiu
  Scenario Outline: verify message for invalid email
    When sign in: I provide email <email>
    Then sign in: I verify invalid email error message

    Examples:
    | email         | pass |
    | abc.com       | 123  |
    | email@email.c | 431  |


  @laurentiu
  Scenario: verify sign in feature
    When sign in: I log in with my valid credentials
#    Then search: I should land on search page






