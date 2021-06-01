# Default sender's email and password
$username   = 'testcase353@gmail.com'
$password   = 'Abc123456.'
$secstr     = New-Object -TypeName System.Security.SecureString
$password.ToCharArray() | ForEach-Object {$secstr.AppendChar($_)}

# Ask for the receiver's email
$emailaddress = Read-Host 'What is your email?'

# To check if the build is successful
$build = "`r`n" +"Build is successful = false"

# Parse result.txt
$a = Get-Content -Path ".\result.txt"
$a | foreach {
    # To get total tests info
    if($_ -ilike "*found*") {
        $total = $_
    }
    # To get failed tests info
    if($_ -ilike "*failed*") {
        $failed = $_
    }
    # To get successsful tests info
    if($_ -ilike "*successful*") {
        $_ | Get-Member
        $passed = "`r"+ $_
        $build = "`r`n" +"Build is successful = True"
    }
}

# Send email with resultSummary.txt
$hash = @{
    from        = "testcase353@gmail.com"
    to          = $emailaddress
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
