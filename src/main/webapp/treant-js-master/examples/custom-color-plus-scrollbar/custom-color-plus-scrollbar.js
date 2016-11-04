var config = {
        container: "#OrganiseChart1",
        rootOrientation:  'WEST', // NORTH || EAST || WEST || SOUTH
        // levelSeparation: 30,
        siblingSeparation:   20,
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
            name: "Bernandino Vázquez Roblero",
            title: "Pastor Local",
            contact: "Tel: 01 213 123 134",
        },
        image: "/treant-js-master/headshots/1.jpg",
        HTMLid: "ceo"
    },

    cto = {
        parent: ceo,
        text:{
            name: "Fernando ????",
            title: "Co-Pastor",
        },
        stackChildren: true,
        image: "../treant-js-master/headshots/default.jpg",
        HTMLid: "coo"
    },
    cbo = {
        parent: ceo,
        text:{
            name: "Ismael  Ramos",
            title: "Secretario",
        },
        image: "../treant-js-master/headshots/default.jpg",
        HTMLid: "cbo"
    },
    cdo = {
        parent: ceo,
        text:{
            name: "Amado Gómez",
            title: "Tesorero",
            contact: "Tel: 01 213 123 134",
        },
        image: "../treant-js-master/headshots/default.jpg",
        HTMLid: "cdo"
    },
    cio = {
        parent: cto,
        text:{
            name: "Ron Blomquist",
            title: "Chief Information Security Officer"
        },
        image: "/headshots/default.png",
        HTMLid: "cio"
    },
    ciso = {
        parent: cto,
        text:{
            name: "Michael Rubin",
            title: "Chief Innovation Officer",
            contact: "we@aregreat.com"
        },
        image: "../headshots/9.jpg",
        HTMLid: "ciso"
    },
    cio2 = {
        parent: cdo,
        text:{
            name: "Erica Reel",
            title: "Chief Customer Officer"
        },
        link: {
            href: "http://www.google.com",
            target: "_blank"
        },
        image: "../headshots/10.jpg",
        HTMLid: "cio2"
    },
    ciso2 = {
        parent: cbo,
        text:{
            name: "Alice Lopez",
            title: "Chief Communications Officer"
        },
        image: "../headshots/7.jpg",
        HTMLid: "ciso2"
    },
    ciso3 = {
        parent: cbo,
        text:{
            name: "Mary Johnson",
            title: "Chief Brand Officer"
        },
        image: "../headshots/4.jpg",
        HTMLid: "ciso2"
    },
    ciso4 = {
        parent: cbo,
        text:{
            name: "Kirk Douglas",
            title: "Chief Business Development Officer"
        },
        image: "../headshots/11.jpg",
        HTMLid: "ciso2"
    }

    ALTERNATIVE = [
        config,
        ceo,
        cto,
        cbo,
        cdo,
        cio,
        ciso,
        cio2,
        ciso2,
        ciso3,
        ciso4
    ];