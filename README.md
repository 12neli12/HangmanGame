# HangmanGame

Hangman Game
Ky aplikacion JavaFX ju mundëson të shijoni lojën klasike Hangman, ku qëllimi është të gjeni fjalën e fshehur duke sugjeruar shkronja. 
Loja ofron një generic user interface (GUI) dhe siguron një përvojë interaktive dhe argëtuese.


Fillimi
Klono Repozitorin:

Klonojeni këtë repozitor në makinën tuaj lokale duke përdorur komandën e mëposhtme:
git clone (url-e-repozitorit)

Ekzekuto Aplikacionin:

Hapni projektin në Eclipse.
Gjeni klasën Main në paketën application dhe ekzekutoni atë për të nisur lojën.

Rregullat e Lojës

Rregullat e Lojës së Hangman janë të thjeshta:

-Një fjalë e fshehur zgjidhet në mënyrë të rastësishme nga një listë e paracaktuar.
-Fjala shfaqet fillimisht si viza, duke paraqitur secilën shkronjë të fjalës.
-Lojtarët duhet ti gjejnë shkronjat një nga një.
-Në qoftë se shkronja është e saktë shfaqen shkronjat përkatëse në fjalë.
-Në rastin kur nuk e gjejmë shkronjën shanset ulen me 1.
-Lojtarët fitojnë duke gjetur saktë fjalën e plotë, dhe humbasin nëse shanset mbarojnë para se të gjejnë fjalën.

Si të Luani

Kur nisim lojën, shfaqet në ekran një përshkrim i shkurtër rreth lojës.
Klikoni butonin "Continue" për të kaluar në ekranin e futjes së emrit të përdoruesit.

Hyrja e Emrit të Përdoruesit:
Shkruani emrin tuaj.
Klikoni butonin "SAVE" për të ruajtur emrin tuaj në file (users.txt) dhe filloni lojën.

Në ekran shfaqet emri i lojtarit, shanset e mbetura dhe një sugjerim për fjalën e fshehur.
Shkruani një shkronjë në kutinën e tekstit dhe klikoni butonin.
Vazhdoni të provoni deri sa të gjeni saktë fjalën ose të mbarojnë shanset.

Nëse gjykonit saktë fjalën, shfaqet një mesazh që tregon që ju fituat.
Nëse mbarojne shanset, loja tregon fjalën e saktë.
Luani Përsëri:

Pas përfundimit të një loje, mund të klikoni butonin tjetër për të filluar një lojë të re.


Skedarë dhe Struktura
Main.java:

Permban klasën kryesore përgjegjëse për nisjen e aplikacionit JavaFX.
Shfaq ekranin fillimor dhe kalon në ekranin e hyrjes së emrit të përdoruesit.

SecondPane.java:
Paraqet ekranin e hyrjes së emrit të përdoruesit.
Ruajt emrin e hyrë në një skedar dhe kalon në ekranin e lojës.

GamePane.java:
Implementon logjikën kryesore të lojës dhe ndërfaqen e përdoruesit.
Merret me zgjedhjen e fjalës, hyrjen e lojtarit dhe shfaqjen e rezultateve të lojës.

WordManager.java:
Menaxhon koleksionin e fjalëve dhe sugjerimeve përkatëse.
Ofron një metodë për të marrë një fjalë dhe një sugjerim të rastësishëm për çdo lojë.

application.css:
Permban stilizime (CSS) për të stilitizuar ndërfaqen e përdoruesit.

Ky aplikacion i Lojës së Hangman është krijuar nga Ornel Mero.
Përzgjedhja dhe sugjerimet e fjalëve sigurohen nga klasa WordManager.
Shijoni lojën e Hangman!