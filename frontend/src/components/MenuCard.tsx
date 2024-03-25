import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

export default function MenuCard(props) {
    return (
        <Card /*sx={{ maxWidth: 345 }}*/ sx={{width: 300}} flex-grow="1">
            <CardMedia
                component="img"
                height="210"
                image={props.imgPath}
            />
            <CardContent>
                <Typography gutterBottom variant="h5" component="div" className={"schriftCard"}>
                    {props.title}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    {props.content}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size="small">Zur Übersicht</Button>
            </CardActions>
        </Card>
    );
}