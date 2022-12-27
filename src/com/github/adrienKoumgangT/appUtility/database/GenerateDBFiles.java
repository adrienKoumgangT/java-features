package com.github.adrienKoumgangT.appUtility.database;

/**
 * <p>
 * Cette classe permet de lire un fichier SQL de création d'une table
 * avec le style MySQL (voir un exemple de fichier dans le dossier files)
 * et génère des query de bases permettant de créer :
 * <ul>
 *     <li>La vue (view)</li>
 *     <li>
 *         les procédures (routines) :
 *         <ul>
 *             <li>
 *                 GET : prend un un identificateur et renvoi l'élément ayant comme clé cet élément dans le tableau.
 *             </li>
 *             <li>
 *                 LIST : renvoi la liste des éléments présents dans le tableau.
 *             </li>
 *             <li>
 *                 SET : prend un identificateur et un ensemble de paramètre correspondant au différentes
 *                 colonnes de ce dernier et créé 2 cas de figures :
 *                 <ul>
 *                     <li>
 *                         1er cas : si l'identificateur est null, créer une nouvelle ligne contenant ayant dans
 *                         chaque case, les valeurs passés en paramètre.
 *                     </li>
 *                     <li>
 *                         2ème cas : si l'identificateur n'est pas null, modifie les cases de la ligne correspondant
 *                         à l'identifiant avec les valeurs passées en paramètre.
 *                     </li>
 *                 </ul>
 *             </li>
 *             <li>
 *                 DEL : prend un identification et cancel la ligne correspondant à cet identifiant de la base de donnée.
 *             </li>
 *         </ul>
 *     </li>
 * </ul>
 * </p>
 * <br>
 *
 * @author Adrien Koumgang Tegantchouang
 * @version Décembre 2022
 * @since 1.0
 */
public class GenerateDBFiles {

}
