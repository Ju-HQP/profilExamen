# Projet : Profil Examen

# Description

Le projet a pour but d'afficher une fiche profil d'un utilisateur fictif.
On peut alors lire les informations du profil, à savoir :
- son nom et son prénom (name)
- son métier (role)
- sa decription (description)
- ses compétences (skills)
- sa diponibilité (availability)
On peut cliquer sur la dispo du profil pour (plus tard) obtenir le mail et le numéro de téléphone.

# Notions Composes utilisées
- composables
- paramètres
- modifiers
- padding externe / interne
- callbacks
- previews
- accessibilité de base

# Explication courte

1. J'ai crée les composables ProfileScreen (écran principal)
 ProfileCard (fiche profil) contenant les infos des composants :
    - ProfileHeader(Nom et role (métier))
    - Text (Description)
    - Skill Item (une Compétence) qui sera affichés sous forme de liste
    - InteractAvailability (Bouton clickable)

2. ProfileScreen représente l'écran principal

3. J'utilise un padding externe dans le composant parent (le composant Screen) pour placer la fiche profil correctement dans l'écran (il prend toute la largeur et met un padding de 24dp)

4. J'utilise un padding interne de 16dp dans le composant Fiche Profil pour avoir de l'espace tout autour et centrer.
Par ailleurs, j'ai également des padding sous chaque bloc d'infos pour les espacer verticalement

5. Le composant InteractionAvailability reçoit un callback (pour le click), et affiche le texte de disponibilité.

6. Dans InteractionAvailability -> Role.Button et semantics pour le lecteur d'écran avec une description de l'action qui serait faite.

 Il y a aussi un fond gris pour faire comprendre que c'est une zone de click pour l'utilisateur. Le click affichera une pop-up pour copier le numéro de téléphone ou le mail du profil.

7. On instancie les composants séparéments, on peut donc les réexploiter, et changer leurs infos grâce aux paralmètres appliqués. On a juste à changer les paramètres.