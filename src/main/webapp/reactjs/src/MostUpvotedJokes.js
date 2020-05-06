import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TablePagination from '@material-ui/core/TablePagination';
import TableRow from '@material-ui/core/TableRow';
// import SearchBar from './SearchBar'
import SearchBar from 'material-ui-search-bar'
import Grid from '@material-ui/core/Grid';
import { red } from "@material-ui/core/colors";
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/styles';
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import Collapse from "@material-ui/core/Collapse";
import Avatar from "@material-ui/core/Avatar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import FavoriteIcon from "@material-ui/icons/Favorite";
import ShareIcon from "@material-ui/icons/Share";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import MoreVertIcon from "@material-ui/icons/MoreVert";
import InputBase from '@material-ui/core/InputBase';
import { Link } from 'react-router-dom';

const styles = theme => ({
    root: {},
    media: {
      height: 0,
      paddingTop: "56.25%" // 16:9
    },
    avatar: {
        backgroundColor: '#453535', 
    }
  });
  
class MostUpvotedJokes extends React.Component {

    state = {
        jokeId: 0,
        isLoaded: false,
        jokeArray: [],
        searchedJoke: ''
    };

    removeDivsFromJokeContent = (jokes) => {
        jokes.map((joke) => {
            let res = joke.content.split("<div>");
            let newRes = '';
            for (let i = 0; i < res.length; i++) {
                newRes = newRes + res[i] + "\n";
            }
            res = newRes.split("</div>");
            newRes = '';
            for (let i = 0; i < res.length; i++) {
                newRes = newRes + res[i] + "\n";
            }
            res = newRes.split("<br>");
            newRes = '';
            for (let i = 0; i < res.length; i++) {
                newRes = newRes + res[i] + "\n";
            }
            res = newRes.split("&nbsp;");
            newRes = '';
            for (let i = 0; i < res.length; i++) {
                newRes = newRes + res[i] + "\n";
            }
            joke.content = newRes;
        })
        return jokes;
    }

    componentDidMount() {
        fetch("http://localhost:8090/jokes")
          .then(res => res.json())
          .then(
            (result) => {
              this.setState({
                isLoaded: true,
                jokeArray: result
              });

              console.log(result);

              let newJokeArray = this.removeDivsFromJokeContent(result);
              this.setState({
                isLoaded: true,
                jokeArray: newJokeArray
              });
            },
            // Note: it's important to handle errors here
            (error) => {
              this.setState({
                isLoaded: true,
                error
              });
            }
          )
      }

    componentDidUpdate = () => {    
        
    }

    handleChangeText = () => {
        console.log("here");

        if (this.state.jokePosterId == this.state.jokeUserId) {
            this.setState({
                ...this.state
            });
        }
        else {
            // do nothing
        }
    }

    handleChange = (prop) => (event) => {
        console.log('URMATORUL PAS');
        this.setState({ 
            ...this.state, 
            [prop]: event.target.value 
        });
      };

    handleLove = () => {    
        console.log('lentile dior');
    }

    handleShare = () => {    
        console.log('geaca de print');
    }

    searchJokes = () => {
        console.log('im searchin for a new joke tati');
    }

  render () {

    const {
        jokes,
        searchedJoke,
        jokeArray
    } = this.state;

    const {
        classes
     } = this.props;


     console.log('The jokarray is as following');
     console.log(jokeArray);

    return (
        <div className>
            <br></br>
            <SearchBar
                style={{marginTop: 50
                }}
                value={searchedJoke}
                onChange={(newValue) => {
                    console.log("s-a modificat textul cautarii");
                    this.setState({ searchedJoke: newValue })}
                }
                onRequestSearch={() => {
                    console.log("trebuie cautate doar glumele care au tagul asta");
                    this.searchJokes(searchedJoke)}
                }
            />
            <br></br>

            {
                this.state.jokeArray.map(joke => (
                    <div >
                       <Card> 
                       <Link to={ `/profile/${joke.posterId}` }
                             className="removeUnderline"
                       >
                        <CardHeader
                            avatar={
                            <Avatar aria-label="recipe" style={{backgroundColor: '#E1173F' }}                
                            >
                                {`${joke.title[0]}`}
                            </Avatar>
                            }
                            title={`${joke.title}`}
                            subheader="September 14, 2016"
                        />
                        </Link>
                       <Link to={ `/viewer/${joke._id}` }
                             className="removeUnderline"
                       >
                        <CardContent className="marginTop">
                            <p className="Blend"
                                onClick={this.handleChangeText}> 
                            { `${joke.content}`} 
                            </p>
                        </CardContent>
                        </Link>
                        </Card>
                    </div>
                ))
            }

            <br></br> 
        </div>
    );
    }
}

MostUpvotedJokes.propTypes = {
    classes: PropTypes.object.isRequired,
 };

 export default withStyles(styles)(MostUpvotedJokes);