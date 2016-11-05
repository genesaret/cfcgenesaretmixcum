var config = {
        container: "#OrganiseChart1",
        rootOrientation:  'NORTH', // NORTH || EAST || WEST || SOUTH
        //levelSeparation: 30,
        siblingSeparation:   10,
        subTeeSeparation:    60,
        scrollbar: "fancy",
        
        connectors: {
            type: 'step'
        },
        node: {
            HTMLclass: 'nodeExample1'
        }
    },
    ceo = {
        text: {
            name: "Bernandino Vázquez",
            title: "Pastor Local",
            contact: "Tel: 01 213 123 134",
        },
        image: "/treant-js-master/examples/headshots/1.jpg",
        HTMLid: "ceo"
    },

    cto = {
        parent: ceo,
        text:{
            name: "Fernando Martínez",
            title: "Co-Pastor",
        },
        stackChildren: true,
        image: "/treant-js-master/examples/headshots/default.jpg",
        HTMLid: "coo"
    },
    cbo = {
        parent: ceo,
        text:{
            name: "Ismael  Ramos",
            title: "Secretario",
        },
        image: "/treant-js-master/examples/headshots/default.jpg",
        HTMLid: "cbo"
    },
    cdo = {
        parent: ceo,
        text:{
            name: "Amado Gómez",
            title: "Tesorero",
            contact: "Tel: 01 213 123 134",
        },
        image: "/treant-js-master/examples/headshots/default.jpg",
        HTMLid: "cdo"
    },
    //cio = {
      //  parent: cto,
      //  text:{
        //    name: "Ron Blomquist",
          //  title: "Chief Information Security Officer"
        //},
        //image: "/treant-js-master/examples/headshots/default.jpg",
        //HTMLid: "cio"
    //},
    //ciso = {
      //  parent: cto,
        //text:{
          //  name: "Michael Rubin",
            //title: "Chief Innovation Officer",
            //contact: "we@aregreat.com"
        //},
        //image: "/treant-js-master/examples/headshots/default.jpg",
        //HTMLid: "ciso"
    //},
    cio2 = {
        parent: cdo,
        text:{
            name: "TBD",
            title: "Auxiliar"
        },
        link: {
            href: "http://www.google.com",
            target: "_blank"
        },
        image: "/treant-js-master/examples/headshots/default.jpg",
        HTMLid: "cio2"
    },
    ciso2 = {
        parent: cbo,
        text:{
            name: "TBD",
            title: "Vocal A"
        },
        image: "/treant-js-master/examples/headshots/default.jpg",
        HTMLid: "ciso2"
    },
    ciso3 = {
        parent: cbo,
        text:{
            name: "TBD",
            title: "Vocal E"
        },
        image: "/treant-js-master/examples/headshots/default.jpg",
        HTMLid: "ciso2"
    },
    ciso4 = {
        parent: cbo,
        text:{
            name: "TBD",
            title: "Vocal I"
        },
        image: "/treant-js-master/examples/headshots/default.jpg",
        HTMLid: "ciso2"
    }

    ALTERNATIVE = [
        config,
        ceo,
        cto,
        cbo,
        cdo,
        //cio,
        //ciso,
        cio2,
        ciso2,
        ciso3,
        ciso4
    ];