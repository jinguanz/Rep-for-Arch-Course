/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function fnCheck()
{               
	/*retriving the User Id*/
	return0=fnCheckId(document.form1.uname.value);
	if(return0==false)
	{
	alert(" Please enter Username");

	return false;
	}
		
	return1=fnCheckPassword(document.form1.pwd.value);
	if(return1==false)
		{
		alert("Please enter Password");
	
		return false;
		}
		else
		{
		return true;
		}
}

function fnCheckPassword(password)
{
	
	if(password.length==0)
	return false;
	
}

function fnCheckId(id)
{
	
	if(id.length==0)
	return false;
	
}

function fnCheckCardData()
{
    return0=fnCardno(document.form1.cardno.value);
	if(return0==false)
	{
	alert(" Please enter a valid 16-digit card number");

	return false;
	}
		
	return1=fnCVV(document.form1.cvv.value);
	if(return1==false)
		{
		alert("Please enter a valid 3-digit cvv");
	
		return false;
		}
		else
		{
		return true;
		}
        return2=fnExpirationMonth(document.form1.month.value)
        if(return1==false)
            {
                alert("Please enter a valid month")
            }
            
            return3=fnExpirationYear(document.form1.year.value)
        if(return1==false)
            {
                alert("Please enter a valid year")
            }
}

function fnCardno(cardNo)
{
    if (cardNo.length!=16)
        return false;
}

function fnCVV(cvv)
{
    if (cvv.length!=3)
        return false;
}
function fnExpirationMonth(month)
{
    if (month.length==null)
        return false;
}
function fnExpirationYear(year)
{
    if (year.length==null)
        return false;
}

function fnValidate_order()
{
	var retvalue;
	
	retvalue = fnValidateCustId_order();
	if(retvalue == false) 
	{ 
		return retvalue; 
	}
	retvalue=fnValidateName_order();

	if(retvalue == false) 
	{ 
		return retvalue; 
	}
	retvalue=fnValidateAddress_order();
	if(retvalue == false) 
	{ 
		return retvalue; 
	}

}
function fnValidateCustId_order()
{
	textfeild1 = document.form1.ID.value;
	flag1 = invoice_fnCheckcustId(textfeild1);
	if(flag1 == 1)
	{
		alert("Please enter your Customer id!");
		
		return false;
	}
	if(flag1 == 2)
	{
		alert("Customer id should contain only numbers!");
		
		return false;
	}
	if(flag1 == 3)
	{
		alert("Customer id should be of four characters long!");
		
		return false;
	}
	return true;
}

function invoice_fnCheckcustId(textfeild1)
{
	if(textfeild1.length==0)
	{
		return 1;
	}
	else if(isNaN(textfeild1))
	{
		return 2;
	}
	else if(textfeild1.length!=4)
	{
		return 3;
	}	
	else
	{
		return 0;
	}
}

function fnValidateName_order()
{
    var value;
    value = document.form1.Recnam.value;
    if(value==null)
        { 
            alert("Enter recipient name");
            return false;
        }
}

function fnValidateAddress_order()
{
    var value;
    value = document.form1.txtaddr.value;
    if(value==null)
        { 
            alert("Enter recipient address");
            return false;
        }
}