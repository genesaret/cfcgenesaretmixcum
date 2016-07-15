
var xmlhttp;

function onVote()
{
	var f = document.getElementById( "poll_form" );
	var a = f.answer;
	var sel = -2;
	for ( var i = 0; i < a.length; i++ )
	{
		if ( a[i].checked)
		{
			sel = a[i].value;
		}
	}

	if ( sel > 0 )
	{
		getVote( sel );
	}
	else
	{
		getVote( -2 );
	}
	return false;
}

function onView()
{
	getVote( -2 );
	return false;
}

function onBack()
{
	getVote( -1 );
	return false;
}

function getVote( int )
{
	xmlhttp=GetXmlHttpObject();
	if ( xmlhttp == null )
	{
		alert ("Browser does not support HTTP Request");
		return;
	}
	var url = "http://www.tkpartes.com.mx/mystore/misc/js/encuesta_ajax_esp.php";
	url = url + "?x=MTQ1Mg==&l=esp&vote=" + int;
	url = url + "&sid=" + Math.random();
	xmlhttp.onreadystatechange = stateChanged;
	xmlhttp.open( "GET", url, true );
	xmlhttp.send( null );
}

function stateChanged()
{
	if ( xmlhttp.readyState == 4 )
	{
		document.getElementById( "poll" ).innerHTML = xmlhttp.responseText;

		var max_idx = 5;
		for( var i = 1; i <= max_idx; i++ )
		{
			var bar = $( '#poll_bar_' + i );
			var w = bar.css( 'width' );
			bar.css( 'width', 0 );
			bar.show();
			bar.animate({
				width: w
			}, 1000 );
		}
	}
}

function GetXmlHttpObject()
{
	var objXMLHttp=null;
	if ( window.XMLHttpRequest )
	{
		objXMLHttp = new XMLHttpRequest();
	}
	else if ( window.ActiveXObject )
	{
		objXMLHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	}
	return objXMLHttp;
}

$(document).ready( function()
{
	getVote( -1 );
});
