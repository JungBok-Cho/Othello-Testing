$username   = 'testcase353@gmail.com'
$password   = 'Abc123456.'
$secstr     = New-Object -TypeName System.Security.SecureString
$password.ToCharArray() | ForEach-Object {$secstr.AppendChar($_)}
$date = Get-Date
$TextFile = ".\result.txt"
$a = Get-Content -Path $TextFile
$build = "`r`n" +"Build is successful = false"
$a | foreach {
    if($_ -ilike "*found*")
    {
        $z = $_.indexOf("found")
        $total = $_
    }

    if($_ -ilike "*failed*")
    {
        $b = $_.indexOf("failed")
        $failed = $_
    }
    if($_ -ilike "*successful*"){
        $_ | Get-Member
        $x = $_.indexOf("successful")
        $passed = "`r"+ $_
        $x | Get-Member
        write-Output $_
        $build = "`r`n" +"Build is successful = True"
    }
    write-Output $_
}
$hash = @{
    from        = "testcase353@gmail.com"
    to          = "chojb2015@gmail.com"
    subject     = "Milestone2 Regression Testing Result"
    smtpserver  = "smtp.gmail.com"
    port        = "587"
    attachments = ".\resultSummary.txt"
    body        = "Hello Professor Mike,`r`n`r`nHere is the regression testing report:`r`n $build `r`n $total `r`n $passed `r`n $failed `r`n `r`nBest,`r`nCho/Peter/Kalyani"
    credential  = New-Object -typename System.Management.Automation.PSCredential -argumentlist $username, $secstr
    usessl      = $true
    verbose     = $true
}

Send-MailMessage @hash
