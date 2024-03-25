import MenuCard from "./MenuCard";
import {useState} from 'react';
import giraffe from '/cardImgs/img.png';
import elephanten from '/cardImgs/img_1.png';
import affe from '/cardImgs/img_2.png';
import loewe from '/cardImgs/img_3.png';
import halle from '/cardImgs/img_4.png';
import pinguine from '/cardImgs/img_5.png'

import {Grid} from "@mui/material";
import {h} from "vite/dist/node/types.d-FdqQ54oU";

function MainPage() {
    const [cardData, setCardData] = new useState([
        {title: 'Masoala Halle', content: 'Die rund eine Hektare grosse Masoala-Halle oder Masoala kely im Zoo Zürich bildet ein Stück des madagassischen Masoala-Regenwaldes ab und beherbergt über 50 verschiedene Wirbeltierarten aus Madagaskar.', imgPath: halle},
        {title: 'Pinguinparade', content: 'Wenn im Winter das Thermometer unter 10 Grad sinkt, können Sie täglich um 13:30 Uhr mit unseren Königspinguinen auf einem kurzen Rundgang durch den Zoo Zürich watscheln – ein einzigartiges Erlebnis für Ihren winterlichen Zoobesuch.', imgPath: pinguine},
        {title: 'Löwen', content: 'Der Löwe ist neben dem Tiger eine der beiden größten Arten aus der Familie der Katzen. Er ist heute nur noch in Teilen Afrikas südlich der Sahara sowie im indischen Bundesstaat Gujarat beheimatet; in Afrika ist er das größte Landraubtier.', imgPath: loewe},
        {title: 'Giraffen', content: 'Die Giraffen, bundesdeutsches und Schweizer Hochdeutsch, österreichisches Hochdeutsch, sind eine Gattung der Säugetiere aus der Ordnung der Paarhufer. ', imgPath: giraffe},
        {title: 'Elephanten', content: 'Die Elefanten sind eine Familie aus der Ordnung der Rüsseltiere. Die Familie stellt die größten gegenwärtig lebenden Landtiere und schließt außerdem die einzigen heute noch lebenden Vertreter der Ordnungsgruppe ein.', imgPath: elephanten},
        {title: 'Affen', content: 'Lemuren kommen ausschließlich auf Madagaskar und kleineren Inseln in der Nähe vor. Hinsichtlich Körperform und Lebensweise sind sie eine sehr vielfältige Gruppe. Die meisten Arten leben auf Bäumen und sind Pflanzen- oder Allesfresser.', imgPath: affe}
    ]);
    return (
        <>
            <Grid container spacing={2} container justifyContent="space-evenly">
                {cardData.map((cardObj) => {
                    return (
                        <Grid item xs={4}>
                            <MenuCard title={cardObj.title} content={cardObj.content} imgPath={cardObj.imgPath}/>
                        </Grid>)
                })}
            </Grid>
        </>

    )
}

export default MainPage;