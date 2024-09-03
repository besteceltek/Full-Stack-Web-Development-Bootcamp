import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import CardActionArea from '@mui/material/CardActionArea';
import CardActions from '@mui/material/CardActions';
import { useContext } from 'react';
import BasketContext from '../context/BasketContext';

export default function ProductsCard({ product }) {
  const { title, description, price, images } = product
  const { addToBasket } = useContext(BasketContext)
  const handleClick = () => {
    addToBasket(product)
  }
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image={ images[0] }
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            { title }
          </Typography>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            { description }
          </Typography>
          <Typography gutterBottom variant="h5" component="div">
            { price }
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button size="small" color="primary" onClick={handleClick}>
          Add to Basket
        </Button>
      </CardActions>
    </Card>
  );
}
