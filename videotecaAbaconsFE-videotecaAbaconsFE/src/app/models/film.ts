import { Genere } from "./genere";
import { Interprete } from "./interprete";


export class Film {
    idFilm?: number;
    titolo?: string;
    anno?: string;
    genere?: Genere;
    interpreti?: Interprete[];
}



